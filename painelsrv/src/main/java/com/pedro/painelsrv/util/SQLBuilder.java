package com.pedro.painelsrv.util;

public class SQLBuilder {

	private StringBuilder field = new StringBuilder();
	private StringBuilder where = new StringBuilder();
	private StringBuilder join = new StringBuilder();
	private StringBuilder groupBy = new StringBuilder();
	private StringBuilder orderBy = new StringBuilder();
	private StringBuilder from = new StringBuilder();

	public SQLBuilder(String table) {

		field.append("SELECT ");
		from.append(" FROM ").append(table).append(" ");
		where.append(" WHERE ");
		groupBy.append(" GROUP BY ");
		orderBy.append(" ORDER BY ");
	}

	public <T> SQLBuilder appendField(T t) {

		if (field.length() > 7) {
			field.append(", ");
		}
		field.append(t);
		return this;
	}

	public <T> SQLBuilder appendWhere(T t) {
		if (where.length() > 7) {
			where.append(" AND ");
		}
		where.append(t);
		return this;
	}

	public <T> SQLBuilder appendJoin(T t) {
		join.append(" ").append(t);
		return this;
	}

	public <T> SQLBuilder appendGroupBy(T t) {
		if (groupBy.length() > 9) {
			groupBy.append(", ");
		}
		groupBy.append(t);
		return this;
	}

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
	public String toSql() {
		return this.toString();
	}

}
