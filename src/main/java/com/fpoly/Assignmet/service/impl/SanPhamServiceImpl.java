package com.fpoly.Assignmet.service.impl;

import com.fpoly.Assignmet.model.entites.SanPham;
import com.fpoly.Assignmet.model.repository.SanPhamRepository;
import com.fpoly.Assignmet.service.SanPhamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SanPhamServiceImpl implements SanPhamService {
    private final SanPhamRepository dongSanPhamRepository;

    @Override
    public List<SanPham> getAll() {
        List<SanPham> dongSPs = dongSanPhamRepository.findAll();
        return dongSPs;
    }

    @Override
    public SanPham save(SanPham dongSP) {
        return dongSanPhamRepository.save(dongSP);
    }

    @Override
    public SanPham edit(SanPham dongSP, UUID id) {
        SanPham cv = findById(id);
        if (Objects.nonNull(cv)) {
            return dongSanPhamRepository.save(
                    SanPham.builder()
                            .id(dongSP.getId())
                            .ma(dongSP.getMa())
                            .ten(dongSP.getTen())
                            .build());
        }
        return cv;
    }

    @Override
    public SanPham delete(UUID id) {
        SanPham dongSP = findById(id);
        if (Objects.nonNull(dongSP)) {
            dongSanPhamRepository.delete(dongSP);
            return dongSP;
        }
        return null;
    }

    @Override
    public SanPham findById(UUID id) {
        Optional<SanPham> dongSP = Optional.ofNullable(dongSanPhamRepository.findById(id).orElse(null));
        if (dongSP.isPresent()) {
            return dongSP.get();
        }
        return null;
    }

    @Override
    public List<SanPham> findByTenLikeIgnoreCase(String ten) {
        return dongSanPhamRepository.findByTenMaLike(ten);
    }

}
