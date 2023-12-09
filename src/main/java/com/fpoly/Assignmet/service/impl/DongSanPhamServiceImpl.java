package com.fpoly.Assignmet.service.impl;

import com.fpoly.Assignmet.model.entites.ChucVu;
import com.fpoly.Assignmet.model.entites.DongSP;
import com.fpoly.Assignmet.model.repository.DongSanPhamRepository;
import com.fpoly.Assignmet.service.DongSanPhamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DongSanPhamServiceImpl implements DongSanPhamService {

    private final DongSanPhamRepository dongSanPhamRepository;

    @Override
    public List<DongSP> getAll() {
        List<DongSP> dongSPs = dongSanPhamRepository.findAll();
        return dongSPs;
    }

    @Override
    public DongSP save(DongSP dongSP) {
        return dongSanPhamRepository.save(dongSP);
    }

    @Override
    public DongSP edit(DongSP dongSP, UUID id) {
        DongSP cv = findById(id);
        if (Objects.nonNull(cv)) {
            return dongSanPhamRepository.save(
                    DongSP.builder()
                            .id(dongSP.getId())
                            .ma(dongSP.getMa())
                            .ten(dongSP.getTen())
                            .build());
        }
        return null;
    }

    @Override
    public DongSP delete(UUID id) {
        DongSP dongSP = findById(id);
        if (Objects.nonNull(dongSP)) {
            dongSanPhamRepository.delete(dongSP);
            return dongSP;
        }
        return null;
    }

    @Override
    public DongSP findById(UUID id) {
        Optional<DongSP> dongSP = Optional.ofNullable(dongSanPhamRepository.findById(id).orElse(null));
        if (dongSP.isPresent()) {
            return dongSP.get();
        }
        return null;
    }

    @Override
    public List<DongSP> findByTenLikeIgnoreCase(String ten) {
        return dongSanPhamRepository.findChucVuByTenMaLike(ten);
    }
}
