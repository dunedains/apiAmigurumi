package com.outrowonderstore.outrowonderstrore_api.service;

import com.outrowonderstore.outrowonderstrore_api.dto.AmigurumiDto;


import java.util.List;

public interface AmigurumiService {
    List<AmigurumiDto> getAllAmigurumi();
    AmigurumiDto getAmigurumiById(Long id);
    AmigurumiDto updateAmigurumi(Long id, AmigurumiDto amigurumiDto);
    AmigurumiDto saveAmigurumi(AmigurumiDto amigurumiDto);
    void deleteAmigurumi(Long id);

}
