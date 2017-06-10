package utils;

import java.util.ArrayList;
public class Query {
    
    private int limit;
    private String order;
    private String[] whereEqualTo;
    private int skip;
    private ArrayList<String[]> WhereLessThanOrEqualTo;
    private ArrayList<String[]> WhereGreaterThanOrEqualTo;

    public ArrayList<String[]> getWhereLessThanOrEqualTo() {
        return WhereLessThanOrEqualTo;
    }

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
