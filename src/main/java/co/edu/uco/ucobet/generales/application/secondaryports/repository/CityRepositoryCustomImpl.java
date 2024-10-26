package co.edu.uco.ucobet.generales.application.secondaryports.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.crosscutting.exception.RepositoryUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;


public class CityRepositoryCustomImpl implements CityRepositoryCustom {


	private EntityManager entityManager;

	public CityRepositoryCustomImpl(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<CityEntity> findByFilter(final CityEntity filter) {
		try {
			var criteriaBuilder = entityManager.getCriteriaBuilder();
			var query = criteriaBuilder.createQuery(CityEntity.class);
			var result = query.from(CityEntity.class);

			var predicates = new ArrayList<>();

			if (!ObjectHelper.isNull(filter)) {
				if (!UUIDHelper.isDefault(filter.getId())) {
					predicates.add(criteriaBuilder.equal(result.get("id"), filter.getId()));
				}

				if (!TextHelper.isEmpty(filter.getName())) {
					predicates.add(criteriaBuilder.equal(result.get("name"), filter.getName()));
				}

				if (!UUIDHelper.isDefault(filter.getState().getId())) {
					predicates.add(criteriaBuilder.equal(result.get("state"), filter.getState()));
				}
			}

			query.select(result).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
			return entityManager.createQuery(query).getResultList();

		} catch (final Exception exception) {
			throw RepositoryUcobetException.create(null, null, exception);
		}
	}

	@Override
	public boolean isCityBeingUsed(UUID cityId) {
		try {
			var criteriaBuilder = entityManager.getCriteriaBuilder();
			var query = criteriaBuilder.createQuery(Long.class);
			var root = query.from(CityEntity.class);

			query.select(criteriaBuilder.count(root)).where(criteriaBuilder.equal(root.get("id"), cityId));

			Long count = entityManager.createQuery(query).getSingleResult();

			return count > 0;

		} catch (final Exception exception) {
			throw RepositoryUcobetException.create("Error al verificar si la ciudad está siendo utilizada", null,
					exception);
		}
	}

	@Override
	public boolean existsByNameAndState(String name, String state) {
		try {
			var criteriaBuilder = entityManager.getCriteriaBuilder();
			var query = criteriaBuilder.createQuery(Long.class);
			var root = query.from(CityEntity.class);

			query.select(criteriaBuilder.count(root)).where(criteriaBuilder.and(
					criteriaBuilder.equal(root.get("name"), name), criteriaBuilder.equal(root.get("state"), state)));

			Long count = entityManager.createQuery(query).getSingleResult();

			return count > 0;

		} catch (final Exception exception) {
			throw RepositoryUcobetException.create(
					"Error al verificar si existe una ciudad con el nombre y estado especificados", null, exception);
		}
	}
}
