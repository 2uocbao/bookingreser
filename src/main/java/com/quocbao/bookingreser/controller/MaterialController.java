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

import com.quocbao.bookingreser.request.MaterialRequest;
import com.quocbao.bookingreser.service.MaterialService;

@RestController
@RequestMapping("/material")
public class MaterialController {

	@Autowired
	MaterialService materialService;

	@PostMapping("/create")
	ResponseEntity<Object> createMaterial(@RequestBody MaterialRequest materialRequest) {
		materialService.createMaterial(materialRequest);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	ResponseEntity<Object> detailMaterial(@PathVariable Long id) {
		return new ResponseEntity<>(materialService.detailMaterial(id), HttpStatus.OK);
	}

	@PutMapping("/{id}/update")
	ResponseEntity<Object> updateMaterial(@PathVariable Long id, @RequestBody MaterialRequest materialRequest) {
		materialService.updateMaterial(id, materialRequest);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{companyId}/byCompany")
	ResponseEntity<Object> getMaterials(@PathVariable Long companyId) {
		return new ResponseEntity<>(materialService.materials(companyId), HttpStatus.OK);
	}

	@GetMapping("/{companyId}/search")
	ResponseEntity<Object> searchMaterial(@PathVariable Long companyId, @RequestParam String keySearch) {
		return new ResponseEntity<>(materialService.findByCode(companyId, keySearch), HttpStatus.OK);
	}
}
