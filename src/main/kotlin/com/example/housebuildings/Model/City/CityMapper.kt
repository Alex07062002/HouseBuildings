package com.example.housebuildings.Model.City

import com.example.housebuildings.Model.MainMapper
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper
@Component
abstract class CityMapper : MainMapper<City, CityDTO>