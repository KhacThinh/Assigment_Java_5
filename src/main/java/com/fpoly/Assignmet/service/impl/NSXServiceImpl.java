package com.fpoly.Assignmet.service.impl;

import com.fpoly.Assignmet.model.entites.NSX;
import com.fpoly.Assignmet.model.repository.NSXRepository;
import com.fpoly.Assignmet.service.NSXService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NSXServiceImpl implements NSXService {
    private final NSXRepository dongSanPhamRepository;
    @Override
    public List<NSX> getAll() {
        List<NSX> dongSPs = dongSanPhamRepository.findAll();
        return dongSPs;
    }

    @Override
    public NSX save(NSX dongSP) {
        return dongSanPhamRepository.save(dongSP);
    }

    @Override
    public NSX edit(NSX dongSP, UUID id) {
        NSX cv = findById(id);
        if (Objects.nonNull(cv)) {
            return dongSanPhamRepository.save(
                    NSX.builder()
                            .id(dongSP.getId())
                            .ma(dongSP.getMa())
                            .ten(dongSP.getTen())
                            .build());
        }
        return null;
    }

    @Override
    public NSX delete(UUID id) {
        NSX dongSP = findById(id);
        if (Objects.nonNull(dongSP)) {
            dongSanPhamRepository.delete(dongSP);
            return dongSP;
        }
        return null;
    }

    @Override
    public NSX findById(UUID id) {
        Optional<NSX> dongSP = Optional.ofNullable(dongSanPhamRepository.findById(id).orElse(null));
        if (dongSP.isPresent()) {
            return dongSP.get();
        }
        return null;
    }

    @Override
    public List<NSX> findByTenLikeIgnoreCase(String ten) {
        return dongSanPhamRepository.findByTenMaLike(ten);
    }
}
