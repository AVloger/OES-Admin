package com.dut.entity;

import java.util.ArrayList;
import java.util.List;

public class PCExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PCExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andPcNameIsNull() {
            addCriterion("pc_name is null");
            return (Criteria) this;
        }

        public Criteria andPcNameIsNotNull() {
            addCriterion("pc_name is not null");
            return (Criteria) this;
        }

        public Criteria andPcNameEqualTo(String value) {
            addCriterion("pc_name =", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameNotEqualTo(String value) {
            addCriterion("pc_name <>", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameGreaterThan(String value) {
            addCriterion("pc_name >", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameGreaterThanOrEqualTo(String value) {
            addCriterion("pc_name >=", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameLessThan(String value) {
            addCriterion("pc_name <", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameLessThanOrEqualTo(String value) {
            addCriterion("pc_name <=", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameLike(String value) {
            addCriterion("pc_name like", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameNotLike(String value) {
            addCriterion("pc_name not like", value, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameIn(List<String> values) {
            addCriterion("pc_name in", values, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameNotIn(List<String> values) {
            addCriterion("pc_name not in", values, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameBetween(String value1, String value2) {
            addCriterion("pc_name between", value1, value2, "pcName");
            return (Criteria) this;
        }

        public Criteria andPcNameNotBetween(String value1, String value2) {
            addCriterion("pc_name not between", value1, value2, "pcName");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Integer value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Integer value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Integer value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Integer value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Integer> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Integer> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andAccountNameIsNull() {
            addCriterion("account_name is null");
            return (Criteria) this;
        }

        public Criteria andAccountNameIsNotNull() {
            addCriterion("account_name is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNameEqualTo(String value) {
            addCriterion("account_name =", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotEqualTo(String value) {
            addCriterion("account_name <>", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThan(String value) {
            addCriterion("account_name >", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("account_name >=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThan(String value) {
            addCriterion("account_name <", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThanOrEqualTo(String value) {
            addCriterion("account_name <=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLike(String value) {
            addCriterion("account_name like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotLike(String value) {
            addCriterion("account_name not like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameIn(List<String> values) {
            addCriterion("account_name in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotIn(List<String> values) {
            addCriterion("account_name not in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameBetween(String value1, String value2) {
            addCriterion("account_name between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotBetween(String value1, String value2) {
            addCriterion("account_name not between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordIsNull() {
            addCriterion("account_password is null");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordIsNotNull() {
            addCriterion("account_password is not null");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordEqualTo(String value) {
            addCriterion("account_password =", value, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordNotEqualTo(String value) {
            addCriterion("account_password <>", value, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordGreaterThan(String value) {
            addCriterion("account_password >", value, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("account_password >=", value, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordLessThan(String value) {
            addCriterion("account_password <", value, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordLessThanOrEqualTo(String value) {
            addCriterion("account_password <=", value, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordLike(String value) {
            addCriterion("account_password like", value, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordNotLike(String value) {
            addCriterion("account_password not like", value, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordIn(List<String> values) {
            addCriterion("account_password in", values, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordNotIn(List<String> values) {
            addCriterion("account_password not in", values, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordBetween(String value1, String value2) {
            addCriterion("account_password between", value1, value2, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andAccountPasswordNotBetween(String value1, String value2) {
            addCriterion("account_password not between", value1, value2, "accountPassword");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("`status` like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("`status` not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andClientFlagIsNull() {
            addCriterion("client_flag is null");
            return (Criteria) this;
        }

        public Criteria andClientFlagIsNotNull() {
            addCriterion("client_flag is not null");
            return (Criteria) this;
        }

        public Criteria andClientFlagEqualTo(Integer value) {
            addCriterion("client_flag =", value, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagNotEqualTo(Integer value) {
            addCriterion("client_flag <>", value, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagGreaterThan(Integer value) {
            addCriterion("client_flag >", value, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("client_flag >=", value, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagLessThan(Integer value) {
            addCriterion("client_flag <", value, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagLessThanOrEqualTo(Integer value) {
            addCriterion("client_flag <=", value, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagIn(List<Integer> values) {
            addCriterion("client_flag in", values, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagNotIn(List<Integer> values) {
            addCriterion("client_flag not in", values, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagBetween(Integer value1, Integer value2) {
            addCriterion("client_flag between", value1, value2, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andClientFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("client_flag not between", value1, value2, "clientFlag");
            return (Criteria) this;
        }

        public Criteria andManageFlagIsNull() {
            addCriterion("manage_flag is null");
            return (Criteria) this;
        }

        public Criteria andManageFlagIsNotNull() {
            addCriterion("manage_flag is not null");
            return (Criteria) this;
        }

        public Criteria andManageFlagEqualTo(Integer value) {
            addCriterion("manage_flag =", value, "manageFlag");
            return (Criteria) this;
        }

        public Criteria andManageFlagNotEqualTo(Integer value) {
            addCriterion("manage_flag <>", value, "manageFlag");
            return (Criteria) this;
        }

        public Criteria andManageFlagGreaterThan(Integer value) {
            addCriterion("manage_flag >", value, "manageFlag");
            return (Criteria) this;
        }

        public Criteria andManageFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("manage_flag >=", value, "manageFlag");
            return (Criteria) this;
        }

        public Criteria andManageFlagLessThan(Integer value) {
            addCriterion("manage_flag <", value, "manageFlag");
            return (Criteria) this;
        }

        public Criteria andManageFlagLessThanOrEqualTo(Integer value) {
            addCriterion("manage_flag <=", value, "manageFlag");
            return (Criteria) this;
        }

        public Criteria andManageFlagIn(List<Integer> values) {
            addCriterion("manage_flag in", values, "manageFlag");
            return (Criteria) this;
        }

        public Criteria andManageFlagNotIn(List<Integer> values) {
            addCriterion("manage_flag not in", values, "manageFlag");
            return (Criteria) this;
        }

        public Criteria andManageFlagBetween(Integer value1, Integer value2) {
            addCriterion("manage_flag between", value1, value2, "manageFlag");
            return (Criteria) this;
        }

        public Criteria andManageFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("manage_flag not between", value1, value2, "manageFlag");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}