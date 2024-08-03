package com.pedro.painelsrv.util;

/**
 * A classe {@code SQLBuilder} facilita a construção dinâmica de consultas SQL
 * nativos em Java. Ela utiliza {@code StringBuilder} para montar cláusulas SQL
 * de forma programática, permitindo adicionar campos, condições, joins,
 * agrupamentos e ordenações de maneira intuitiva e organizada.
 */
public class SQLBuilder {

	private StringBuilder field = new StringBuilder();
	private StringBuilder where = new StringBuilder();
	private StringBuilder join = new StringBuilder();
	private StringBuilder groupBy = new StringBuilder();
	private StringBuilder orderBy = new StringBuilder();
	private StringBuilder from = new StringBuilder();

	/**
	 * Constrói uma nova instância de {@code SQLBuilder} para a tabela especificada.
	 *
	 * @param table o nome da tabela de onde os dados serão selecionados
	 */
	public SQLBuilder(String table) {
		if (table == null || table.trim().isEmpty()) {
			throw new IllegalArgumentException("Table name cannot be null or empty");
		}
		field.append("SELECT ");
		from.append(" FROM ").append(table).append(" ");
		where.append(" WHERE ");
		groupBy.append(" GROUP BY ");
		orderBy.append(" ORDER BY ");
	}

	/**
	 * Adiciona um campo à cláusula {@code SELECT}.
	 *
	 * @param field o campo a ser adicionado
	 * @return a instância atual de {@code SQLBuilder}
	 */
	public SQLBuilder appendField(String field) {
		if (field == null || field.trim().isEmpty()) {
			throw new IllegalArgumentException("Field cannot be null or empty");
		}
		if (this.field.length() > 7) {
			this.field.append(", ");
		}
		this.field.append(field);
		return this;
	}

	/**
	 * Adiciona uma condição à cláusula {@code WHERE}.
	 *
	 * @param condition a condição a ser adicionada
	 * @return a instância atual de {@code SQLBuilder}
	 */
	public SQLBuilder appendWhere(String condition) {
		if (condition == null || condition.trim().isEmpty()) {
			throw new IllegalArgumentException("Condition cannot be null or empty");
		}
		if (where.length() > 7) {
			where.append(" AND ");
		}
		where.append(condition);
		return this;
	}

	/**
	 * Adiciona uma cláusula {@code JOIN}.
	 *
	 * @param joinClause a cláusula {@code JOIN} a ser adicionada
	 * @return a instância atual de {@code SQLBuilder}
	 */
	public SQLBuilder appendJoin(String joinClause) {
		if (joinClause == null || joinClause.trim().isEmpty()) {
			throw new IllegalArgumentException("Join clause cannot be null or empty");
		}
		join.append(" ").append(joinClause);
		return this;
	}

	/**
	 * Adiciona um campo à cláusula {@code GROUP BY}.
	 *
	 * @param field o campo a ser adicionado
	 * @return a instância atual de {@code SQLBuilder}
	 */
	public SQLBuilder appendGroupBy(String field) {
		if (field == null || field.trim().isEmpty()) {
			throw new IllegalArgumentException("Field cannot be null or empty");
		}
		if (groupBy.length() > 9) {
			groupBy.append(", ");
		}
		groupBy.append(field);
		return this;
	}

	/**
	 * Adiciona um campo à cláusula {@code ORDER BY}.
	 *
	 * @param field o campo a ser adicionado
	 * @return a instância atual de {@code SQLBuilder}
	 */
	public SQLBuilder appendOrderBy(String field) {
		if (field == null || field.trim().isEmpty()) {
			throw new IllegalArgumentException("Field cannot be null or empty");
		}
		if (orderBy.length() > 10) {
			orderBy.append(", ");
		}
		orderBy.append(field);
		return this;
	}

	/**
	 * Retorna a cláusula {@code WHERE} como uma {@code String}.
	 *
	 * @return a cláusula {@code WHERE}
	 */
	public String toWhere() {
		return where.toString();
	}

	/**
	 * Retorna a cláusula {@code SELECT} como uma {@code String}.
	 *
	 * @return a cláusula {@code SELECT}
	 */
	public String toField() {
		return field.toString();
	}

	/**
	 * Retorna a cláusula {@code JOIN} como uma {@code String}.
	 *
	 * @return a cláusula {@code JOIN}
	 */
	public String toJoin() {
		return join.toString();
	}

	/**
	 * Retorna a cláusula {@code GROUP BY} como uma {@code String}.
	 *
	 * @return a cláusula {@code GROUP BY}
	 */
	public String toGroupBy() {
		return groupBy.toString();
	}

	/**
	 * Retorna a cláusula {@code ORDER BY} como uma {@code String}.
	 *
	 * @return a cláusula {@code ORDER BY}
	 */
	public String toOrderBy() {
		return orderBy.toString();
	}

	/**
	 * Retorna a consulta SQL final construída.
	 *
	 * @return a consulta SQL como uma {@code String}
	 */
	@Override
	public String toString() {
		return build().toString();
	}

	/**
	 * Constrói a consulta SQL final usando {@code StringBuilder}.
	 *
	 * @return a consulta SQL como um {@code StringBuilder}
	 */
	public StringBuilder build() {
		StringBuilder sql = new StringBuilder();
		sql.append(field).append(from).append(join);
		if (where.length() > 6) {
			sql.append(where);
		}
		if (groupBy.length() > 10) {
			sql.append(groupBy);
		}
		if (orderBy.length() > 10) {
			sql.append(orderBy);
		}
		return sql;
	}

	/**
	 * Retorna a consulta SQL final construída. Este método é um alias para
	 * {@code toString()}.
	 *
	 * @return a consulta SQL como uma {@code String}
	 */
	public String toSql() {
		return this.toString();
	}
}
