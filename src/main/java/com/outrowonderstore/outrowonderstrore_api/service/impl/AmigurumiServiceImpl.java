package com.outrowonderstore.outrowonderstrore_api.service.impl;

import com.outrowonderstore.outrowonderstrore_api.dto.AmigurumiDto;
import com.outrowonderstore.outrowonderstrore_api.mapper.AmigurumiMapper;
import com.outrowonderstore.outrowonderstrore_api.repository.AmigurumiRepository;
import com.outrowonderstore.outrowonderstrore_api.service.AmigurumiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AmigurumiServiceImpl implements AmigurumiService {
    private final AmigurumiRepository repository;
    private final AmigurumiMapper mapper;
    @Override
    public List<AmigurumiDto> getAllAmigurumi() {
        return mapper.toDtoList(repository.findAll());
    }
    @Override
    public AmigurumiDto getAmigurumiById(Long id) {
        return mapper.toDtoList(repository.findById(id).orElseThrow());
    }
    @Override
    public AmigurumiDto updateAmigurumi(Long id, AmigurumiDto amigurumiDto) {
        return mapper.toDtoList(repository.save(mapper.toEntity(amigurumiDto)));
    }
    @Override
    public AmigurumiDto saveAmigurumi(AmigurumiDto amigurumiDto) {
        return mapper.toDtoList(repository.save(mapper.toEntity(amigurumiDto)));
    }
    @Override
    public void deleteAmigurumi(Long id) {
        repository.deleteById(id);
    }



}
