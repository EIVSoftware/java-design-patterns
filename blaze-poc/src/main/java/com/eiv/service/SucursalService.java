package com.eiv.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.springframework.stereotype.Service;

import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.eiv.data.model.QSucursalEntity;
import com.eiv.data.model.SucursalEntity;
import com.eiv.view.mapper.SucursalMapper;
import com.eiv.view.model.SucursalModel;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SucursalService {

    private final SucursalMapper sucursalMapper;

    private final EntityManager em;
    private final CriteriaBuilderFactory cbf;

    public Optional<SucursalModel> findById(Long id) {

        CriteriaBuilder<SucursalEntity> cb = cbf.create(em, SucursalEntity.class)
                .from(SucursalEntity.class, "s")
                .where("s.id").eq(id);
        Optional<SucursalEntity> sucursal;
        try {
            sucursal = Optional.of(cb.getSingleResult());
        } catch (NoResultException e) {
            sucursal = Optional.empty();
        } catch (NonUniqueResultException e) {
            sucursal = Optional.empty();
            log.error("La consulta retornó más de un resultado");
        }
        return sucursal.map(sucursalMapper::toFullModel);
    }

    public List<SucursalModel> findAll() {

        CriteriaBuilder<SucursalEntity> cb = cbf.create(em, SucursalEntity.class);
        return cb.getResultList().stream()
                .map(sucursalMapper::toFullModel).collect(Collectors.toList());
    }

    public List<String> findAllNombres() {

        QSucursalEntity q = QSucursalEntity.sucursalEntity;
        return new BlazeJPAQuery<String>(em, cbf).from(q).select(q.nombre).fetch();
        /*
        CriteriaBuilder<String> cb = cbf.create(em, String.class)
                .from(SucursalEntity.class, "s")
                .select("s.nombre");
        return cb.getResultList();
        */
    }

}
