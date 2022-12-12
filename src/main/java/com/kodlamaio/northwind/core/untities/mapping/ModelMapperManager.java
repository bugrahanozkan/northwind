package com.kodlamaio.northwind.core.untities.mapping;

import javax.persistence.SecondaryTable;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class ModelMapperManager implements RentaCarModelMapperService {
	
	
private ModelMapper modelMapper;
	
	@Override
	public ModelMapper forRequest() {
		
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
		return this.modelMapper;
	}

	
	
	@Override
	public ModelMapper forResponse() {
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
		return this.modelMapper;
	}

}
