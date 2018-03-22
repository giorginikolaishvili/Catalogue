package model;

public class ResultModel {
    private String result;

    public ResultModel(String result) {
        this.result = result;
    }
public ResultModel(){}
    @Override
    public String toString() {
        return "ResultModel{" +
                "result='" + result + '\'' +
                '}';
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
