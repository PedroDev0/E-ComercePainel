package com.pedro.painelsrv.util;


/**
 * A classe {@code SQLBuilder} facilita a construção dinâmica de consultas SQL nativos em Java.
 * Ela utiliza {@code StringBuilder} para montar cláusulas SQL de forma programática,
 * permitindo adicionar campos, condições, joins, agrupamentos e ordenações de maneira intuitiva e organizada.
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
		
		field.append("SELECT ");
		from.append(" FROM ").append(table).append(" ");
		where.append(" WHERE ");
		groupBy.append(" GROUP BY ");
		orderBy.append(" ORDER BY ");
	}

	 /**
     * Adiciona um campo à cláusula {@code SELECT}.
     *
     * @param t o campo a ser adicionado
     * @param <T> o tipo do campo
     */
	public <T> SQLBuilder appendField(T t) {

		if (field.length() > 7) {
			field.append(", ");
		}
		field.append(t);
		return this;
	}

	 /**
     * Adiciona uma condição à cláusula {@code WHERE}, incluindo automaticamente o operador {@code AND} quando necessário.
     *
     * @param t a condição a ser adicionada
     * @param <T> o tipo da condição
     */
	public <T> SQLBuilder appendWhere(T t) {
		if (where.length() > 7) {
			where.append(" AND ");
		}
		where.append(t);
		return this;
	}

	  /**
     * Adiciona uma cláusula {@code JOIN}.
     *
     * @param t a cláusula {@code JOIN} a ser adicionada
     * @param <T> o tipo da cláusula {@code JOIN}
     */
	public <T> SQLBuilder appendJoin(T t) {
		join.append(" ").append(t);
		return this;
	}

	   /**
     * Adiciona um campo à cláusula {@code GROUP BY}.
     *
     * @param t o campo a ser adicionado
     * @param <T> o tipo do campo
     */
	public <T> SQLBuilder appendGroupBy(T t) {
		if (groupBy.length() > 9) {
			groupBy.append(", ");
		}
		groupBy.append(t);
		return this;
	}
	
	/**
     * Adiciona um campo à cláusula {@code ORDER BY}.
     *
     * @param t o campo a ser adicionado
     * @param <T> o tipo do campo
     */

	public <T> SQLBuilder appendOrderBy(T t) {
		if (orderBy.length() > 10) {
			orderBy.append(", ");
		}
		orderBy.append(t);
		return this;
	}

	public String toWhere() {
		return where.toString();
	}
	public String toField() {
		return field.toString();
	}
	public String toJoin() {
		return join.toString();
	}
	public String toGroupBy() {
		return groupBy.toString();
	}
	public String toOrderBy() {
		return groupBy.toString();
	}
	

	 /**
    * Retorna a consulta SQL final construída.
    *
    * @return a consulta SQL como uma {@code String}
    */
	@Override
	public String toString() {
		StringBuilder sql = new StringBuilder();
		sql.append(field).append(" ").append(from).append(join);
		if (where.length() > 6) {
			sql.append(" ").append(where);
		}
		if (groupBy.length() > 10) {
			sql.append(" ").append(groupBy);
		}
		if (orderBy.length() > 10) {
			sql.append(" ").append(orderBy);
		}
		return sql.toString();
	}

	/**
    * Retorna a consulta SQL final construída.
    * Este método é um alias para {@code toString()}.
    *
    * @return a consulta SQL como uma {@code String}
    */
	public String toSql() {
		return this.toString();
	}
}
