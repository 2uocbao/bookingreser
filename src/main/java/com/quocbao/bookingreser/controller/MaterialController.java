package com.quocbao.bookingreser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.quocbao.bookingreser.request.MaterialRequest;
import com.quocbao.bookingreser.response.MaterialResponse;
import com.quocbao.bookingreser.service.MaterialService;

@RestController
@RequestMapping("/materials")
public class MaterialController {

	@Autowired
	MaterialService materialService;

	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createMaterial(@RequestBody MaterialRequest materialRequest) {
		materialService.createMaterial(materialRequest);
	}

	@GetMapping("/{id}/detail")
	@ResponseStatus(code = HttpStatus.OK)
	public MaterialResponse detailMaterial(@PathVariable Long id) {
		return materialService.detailMaterial(id);
	}

	@PutMapping("/update")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void updateMaterial(@RequestBody MaterialRequest materialRequest) {
		materialService.updateMaterial(materialRequest);
	}

	@GetMapping("/{companyId}/company")
	@ResponseStatus(code = HttpStatus.OK)
	public List<MaterialResponse> getMaterials(@PathVariable Long companyId) {
		return materialService.materials(companyId);
	}
}
