package com.tutal.wordik.mapper;

import com.tutal.wordik.model.WordikModel;
import com.tutal.wordik.model.WordikResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WordikMapper {

    WordikResource toWordikResource(WordikModel wordikModel);

}
