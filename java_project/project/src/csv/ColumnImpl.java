package csv;

import java.util.ArrayList;
import java.util.List;

class ColumnImpl implements Column{



    List<String> header = new ArrayList<>();

    List<String> datas = new ArrayList<String>();//col 데이터를 스트링 타입으로 넣어줌.


    List<String> col_values = new ArrayList<String>(); // 값을 넣어줄 리스트

    String Data_Type = ""; //데이터 타입을 반환하기위한 스티링 선언.
    int Non_Null_cnt;


    void make_Header_Column(TableImpl ta){ //헤더를 뽑아서 ta안에 있는 head(col객체).datas(데이터 넣는 곳)에 추가.
        for(int i=0; i<ta.temp_data.get(0).size(); i++){
            ta.Head.datas.add(ta.temp_data.get(0).get(i));
        }
    }

    void check_non_null_cnt(ColumnImpl c){
        c.Non_Null_cnt = 0;

        for(int i=0; i<c.datas.size(); i++){
            if(!c.datas.get(i).equals("") ){
                c.Non_Null_cnt += 1;
            }
        }
    }

    void make_head_column(TableImpl ta){
        for(int i=0; i< ta.temp_data.get(0).size(); i++){
            ta.Head.datas.add(ta.temp_data.get(0).get(i));
        }
    }

    void check_type(ColumnImpl col){
        col.Data_Type = "int";
        try{
            for(int i =0; i<col.datas.size(); i++){ // 데이터의 길이 만큼. (열의 개수)
                if(col.datas.get(i).equals("")){
                    continue;
                }
                Integer.parseInt(col.datas.get(i));
            }
        } catch (NumberFormatException e){ //정수가 아닐 때.
            try{
                for(int i=0; i<col.datas.size(); i++){
                    if(col.datas.get(i).equals("")){
                        continue;
                    }
                    Double.parseDouble(col.datas.get(i));
                }
                col.Data_Type ="double";
            }catch (NumberFormatException e2){
                col.Data_Type ="String"; //정수형 더블 둘다 아니면 스트링임.
            }
        }
    }


    @Override
    public String getHeader() {
        return null;
    }

    @Override
    public String getValue(int index) {
        return null;
    }

    @Override
    public <T extends Number> T getValue(int index, Class<T> t) {
        return null;
    }

    @Override
    public void setValue(int index, String value) {

    }

    @Override
    public <T extends Number> void setValue(int index, T value) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void print() {

    }

    @Override
    public boolean isNumericColumn() {
        return false;
    }

    @Override
    public long getNullCount() {
        return 0;
    }

    @Override
    public long getNumericCount() {
        return 0;
    }

    @Override
    public double getNumericMin() {
        return 0;
    }

    @Override
    public double getNumericMax() {
        return 0;
    }

    @Override
    public double getMean() {
        return 0;
    }

    @Override
    public double getStd() {
        return 0;
    }

    @Override
    public double getQ1() {
        return 0;
    }

    @Override
    public double getMedian() {
        return 0;
    }

    @Override
    public double getQ3() {
        return 0;
    }

    @Override
    public boolean fillNullWithMean() {
        return false;
    }

    @Override
    public boolean fillNullWithZero() {
        return false;
    }

    @Override
    public boolean standardize() {
        return false;
    }

    @Override
    public boolean normalize() {
        return false;
    }

    @Override
    public boolean factorize() {
        return false;
    }
}
