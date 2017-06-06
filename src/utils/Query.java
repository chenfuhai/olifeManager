package utils;

/**
 * ��Ų�ѯ�Ĳ��� ������������� �������Ϳͻ��˶���һ��һ������ Ȼ����Gson����Ϣ������ȥ
 * �����������Ϣ������SQL ���
 *
 * order ������ͷ�������� ���� Ȼ����������
 */
public class Query {
    private String tableName;
    private Integer limit;
    private String order;
    private String whereEqualTo;
    private Integer skip;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getWhereEqualTo() {
        return whereEqualTo;
    }

    public void setWhereEqualTo(String whereEqualTo) {
        this.whereEqualTo = whereEqualTo;
    }

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
    }

	@Override
	public String toString() {
		return "Query [tableName=" + tableName + ", limit=" + limit + ", order=" + order + ", whereEqualTo="
				+ whereEqualTo + ", skip=" + skip + "]";
	}
    
    
}
