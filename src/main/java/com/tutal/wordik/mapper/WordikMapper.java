package com.tutal.wordik.mapper;

import com.tutal.wordik.model.WordikModel;
import org.mapstruct.Mapper;

@Mapper
public interface WordikMapper {

    WordikModel toWordikModel(WordikModel wordikModel);

}
