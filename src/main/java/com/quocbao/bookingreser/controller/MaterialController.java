package com.quocbao.bookingreser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quocbao.bookingreser.common.DataResponse;
import com.quocbao.bookingreser.request.MaterialRequest;
import com.quocbao.bookingreser.service.MaterialService;

@RestController
@RequestMapping("/material")
public class MaterialController {

	@Autowired
	MaterialService materialService;

	@PostMapping("/create")
	ResponseEntity<DataResponse> createMaterial(@RequestBody MaterialRequest materialRequest) {
		materialService.createMaterial(materialRequest);
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	ResponseEntity<DataResponse> detailMaterial(@PathVariable Long id) {
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK, materialService.detailMaterial(id)), HttpStatus.OK);
	}

	@PutMapping("/{id}/update")
	ResponseEntity<DataResponse> updateMaterial(@PathVariable Long id, @RequestBody MaterialRequest materialRequest) {
		materialService.updateMaterial(id, materialRequest);
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping("/{companyId}/byCompany")
	ResponseEntity<DataResponse> getMaterials(@PathVariable Long companyId) {
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK, materialService.materials(companyId)),
				HttpStatus.OK);
	}

	@GetMapping("/{companyId}/search")
	ResponseEntity<DataResponse> searchMaterial(@PathVariable Long companyId, @RequestParam("key") String keySearch) {
		return new ResponseEntity<>(new DataResponse(HttpStatus.OK, materialService.findByCode(companyId, keySearch)),
				HttpStatus.OK);
	}
}
