package com.sopra.dao;

import com.sopra.model.CandidatTest;

public interface ICandidatTestDAO extends IDAO<CandidatTest> {
	public CandidatTest findByCode(String code);
}
