package utils;

import java.util.ArrayList;

/**
 * 存放查询的参数 方便服务器解析 服务器和客户端都有一个一样的类 然后用Gson将信息传递上去
 * 依据里面的信息来制作SQL 语句
 *
 * order 正负开头代表正序 逆序 然后是属性名
 */
public class Query {
    
    private Integer limit;//拿出数据的个数限制
    private String order;//排序
    private String[] whereEqualTo;//数据名称以及对应值
    private Integer skip;//跳过数据的个数
    private ArrayList<String[]> WhereLessThanOrEqualTo;
    private ArrayList<String[]> WhereGreaterThanOrEqualTo;

    public ArrayList<String[]> getWhereLessThanOrEqualTo() {
        return WhereLessThanOrEqualTo;
    }

    /**
     * String[] 里面存一对参数 ArrayList有多个参数对
     * @param whereLessThanOrEqualTo
     */
    public void setWhereLessThanOrEqualTo(ArrayList<String[]> whereLessThanOrEqualTo) {
        WhereLessThanOrEqualTo = whereLessThanOrEqualTo;
    }

    public ArrayList<String[]> getWhereGreaterThanOrEqualTo() {
        return WhereGreaterThanOrEqualTo;
    }

    public void setWhereGreaterThanOrEqualTo(ArrayList<String[]> whereGreaterThanOrEqualTo) {
        WhereGreaterThanOrEqualTo = whereGreaterThanOrEqualTo;
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

    public String[] getWhereEqualTo() {
        return whereEqualTo;
    }

    public void setWhereEqualTo(String[] whereEqualTo) {
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
        return "Query{" +
                "limit=" + limit +
                ", order='" + order + '\'' +
                ", whereEqualTo='" + whereEqualTo + '\'' +
                ", skip=" + skip +
                '}';
    }
}
