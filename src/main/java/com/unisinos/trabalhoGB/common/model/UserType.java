package com.unisinos.trabalhoGB.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserType {
	
	NURSE("Enfermeiro"), RESPONSIBLE("Responsável"), ELDERLY("Idoso");

	private final String type;

	@Override
	public String toString() {
		return type;
	}
}
