package com.fpoly.Assignmet.service.impl;

import com.fpoly.Assignmet.model.entites.ChucVu;
import com.fpoly.Assignmet.model.repository.ChucVuRepository;
import com.fpoly.Assignmet.service.ChucVuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChucVuServiceImpl implements ChucVuService {

    private final ChucVuRepository chucVuRepository;

    @Override
    public List<ChucVu> getAll() {
        List<ChucVu> chucVus = chucVuRepository.findAll();
        return chucVus;
    }

    @Override
    public ChucVu save(ChucVu chucVu) {
        return chucVuRepository.save(chucVu);
    }

    @Override
    public ChucVu edit(ChucVu chucVu, UUID id) {
        ChucVu cv = findById(id);
        if (Objects.nonNull(cv)) {
            return chucVuRepository.save(
                    ChucVu.builder()
                            .id(chucVu.getId())
                            .ma(chucVu.getMa())
                            .ten(chucVu.getTen())
                            .build());
        }
        return null;

    }

    @Override
    public ChucVu delete(UUID id) {
        ChucVu chucVu = findById(id);
        if (Objects.nonNull(chucVu)) {
            chucVuRepository.delete(chucVu);
            return chucVu;
        }
        return null;
    }

    @Override
    public ChucVu findById(UUID id) {
        Optional<ChucVu> chucVu = Optional.ofNullable(chucVuRepository.findById(id).orElse(null));
        if (chucVu.isPresent()) {
            return chucVu.get();
        }
        return null;
    }

    @Override
    public List<ChucVu> findByTenLikeIgnoreCase(String ten) {
        List<ChucVu> chucVus = chucVuRepository.findChucVuByTenMaLike(ten);
        return chucVus;
    }
}
