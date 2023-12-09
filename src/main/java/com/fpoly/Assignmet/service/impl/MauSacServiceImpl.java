package com.fpoly.Assignmet.service.impl;

import com.fpoly.Assignmet.model.entites.MauSac;
import com.fpoly.Assignmet.model.repository.MauSacRepository;
import com.fpoly.Assignmet.service.MauSacService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MauSacServiceImpl implements MauSacService {
    private final MauSacRepository dongSanPhamRepository;

    @Override
    public List<MauSac> getAll() {
        List<MauSac> dongSPs = dongSanPhamRepository.findAll();
        return dongSPs;
    }

    @Override
    public MauSac save(MauSac dongSP) {
        return dongSanPhamRepository.save(dongSP);
    }

    @Override
    public MauSac edit(MauSac dongSP, UUID id) {
        MauSac cv = findById(id);
        if (Objects.nonNull(cv)) {
            return dongSanPhamRepository.save(
                    MauSac.builder()
                            .id(dongSP.getId())
                            .ma(dongSP.getMa())
                            .ten(dongSP.getTen())
                            .build());
        }
        return null;
    }

    @Override
    public MauSac delete(UUID id) {
        MauSac dongSP = findById(id);
        if (Objects.nonNull(dongSP)) {
            dongSanPhamRepository.delete(dongSP);
            return dongSP;
        }
        return null;
    }

    @Override
    public MauSac findById(UUID id) {
        Optional<MauSac> dongSP = Optional.ofNullable(dongSanPhamRepository.findById(id).orElse(null));
        if (dongSP.isPresent()) {
            return dongSP.get();
        }
        return null;
    }

    @Override
    public List<MauSac> findByTenLikeIgnoreCase(String ten) {
        return dongSanPhamRepository.findByTenMaLike(ten);
    }
}
