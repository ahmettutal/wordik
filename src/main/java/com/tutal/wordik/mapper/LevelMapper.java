package com.tutal.wordik.mapper;

import com.tutal.wordik.model.LevelModel;
import com.tutal.wordik.model.LevelResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LevelMapper {

    LevelResource toLevelResource(LevelModel levelModel);

}
