package com.kodlamaio.northwind.core.untities.mapping;

import org.modelmapper.ModelMapper;

public interface RentaCarModelMapperService {
	ModelMapper forRequest();
	ModelMapper forResponse();
}
