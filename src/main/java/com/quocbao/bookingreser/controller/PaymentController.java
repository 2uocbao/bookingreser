package com.quocbao.bookingreser.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quocbao.bookingreser.common.DataResponse;
import com.quocbao.bookingreser.common.PaymentConfig;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/create")
	public ResponseEntity<Object> createPayment(@RequestParam("orderType") String orderType,
			@RequestParam("amountTotal") int amountTotal, @RequestParam("bankCode") String bankCode)
			throws UnsupportedEncodingException {
		String vnp_TxnRef = PaymentConfig.getRandomNumber(8);
		String vnp_TmnCode = PaymentConfig.vnpTmnCode;

		Map<String, String> vnp_Params = new HashMap<>();
		vnp_Params.put("vnp_Version", PaymentConfig.vnpVersion);
		vnp_Params.put("vnp_Command", PaymentConfig.vnpCommand);
		vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
		vnp_Params.put("vnp_Amount", String.valueOf(amountTotal * 100));
		vnp_Params.put("vnp_CurrCode", "VND");
		vnp_Params.put("vnp_Locale", "vn");
		vnp_Params.put("vnp_ReturnUrl", PaymentConfig.vnpReturnurl);
		vnp_Params.put("vnp_IpAddr", "13.160.92.202");

		if (bankCode != null && !bankCode.isEmpty()) {
			vnp_Params.put("vnp_BankCode", bankCode);
		}
		vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
		vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);

		Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String vnp_CreateDate = formatter.format(cld.getTime());
		vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

		cld.add(Calendar.MINUTE, 15);
		String vnp_ExpireDate = formatter.format(cld.getTime());
		vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

		List fieldNames = new ArrayList(vnp_Params.keySet());
		Collections.sort(fieldNames);
		String hashData = null;
		String query = null;
		Iterator itr = fieldNames.iterator();
		while (itr.hasNext()) {
			String fieldName = (String) itr.next();
			String fieldValue = vnp_Params.get(fieldName);
			if ((fieldValue != null) && (fieldValue.length() > 0)) {
				// Build hash data
				hashData = hashData + fieldName;
				hashData = hashData + "=" + URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString());
				// Build query
				query = query + URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()) + "="
						+ URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString());
				if (itr.hasNext()) {
					query = query + "&";
					hashData = hashData + "&";
				}
			}
		}
		String queryUrl = query;
		String vnp_SecureHash = PaymentConfig.hmacSHA512(PaymentConfig.vnpHashSecret, hashData);
		queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
		String paymentUrl = PaymentConfig.vnpPayUrl + "?" + queryUrl;
		return new ResponseEntity<>(paymentUrl, HttpStatus.OK);
	}

	@GetMapping("/success")
	public ResponseEntity<DataResponse> successPayment() {
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK), HttpStatus.OK);
	}
}
