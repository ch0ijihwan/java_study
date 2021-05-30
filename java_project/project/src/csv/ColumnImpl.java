package csv;

import java.util.ArrayList;
import java.util.List;

class ColumnImpl implements Column {

    String str_header =null;

    List<String> header = new ArrayList<>();

    List<String> datas = new ArrayList<String>();//col 데이터를 스트링 타입으로 넣어줌.


    List<String> col_values = new ArrayList<String>(); // 값을 넣어줄 리스트

    String Data_Type = ""; //데이터 타입을 반환하기위한 스티링 선언.
    int Non_Null_cnt;


    void make_Header_Column(TableImpl ta) { //헤더를 뽑아서 ta안에 있는 head(col객체).datas(데이터 넣는 곳)에 추가.
        for (int i = 0; i < ta.temp_data.get(0).size(); i++) {
            ta.Head.datas.add(ta.temp_data.get(0).get(i));
        }
    }

    void print_Head(int t){
        int cnt= getHeader().length();
        for(int i=0; i<count(); i++){
            try{
                if(cnt < getValue(i).length()){
                    cnt = getValue(i).length();
                }
            }
            catch (NullPointerException e){
                cnt =cnt;
            }
        }

        try {
            cnt = cnt - getHeader().length();
        } catch (NullPointerException e){
            cnt = cnt -4;
        }

        String blank ="";

        for(int i=0; i<cnt; i++){
            blank +=" ";
        }
        System.out.printf("%s%s |", blank,getHeader());
    }
    void print(int t){
        int cnt= getHeader().length();
        for(int i=0; i<count(); i++){
            try {
                if (cnt < getValue(i).length()) {
                    cnt = getValue(i).length();
                }
            } catch (NullPointerException e){
                cnt = cnt;
            }
        }

        try {
            cnt = cnt - getValue(t).length();
        } catch(NullPointerException e){
            cnt = cnt -4;
        }


        String blank ="";

        for(int i=0; i<cnt; i++){
            blank +=" ";
        }

        System.out.printf("%s%s |", blank,getValue(t));
    }


    void check_non_null_cnt(ColumnImpl c) {
        c.Non_Null_cnt = 0;


        for (int i = 0; i < c.datas.size(); i++) {
            try {
                if (!c.datas.get(i).equals(null)) {
                    c.Non_Null_cnt += 1;
                }
            }
            catch(NullPointerException e){
                continue;
            }
        }


    }

    void make_head_column(TableImpl ta) {
        for (int i = 0; i < ta.temp_data.get(0).size(); i++) {
            ta.Head.datas.add(ta.temp_data.get(0).get(i));
        }
    }

    String check_type(ColumnImpl column) {
        String type = "int";
        try {
            for (int i = 0; i < datas.size(); i++) {
                Integer.parseInt(datas.get(i));
            }
        } catch (NumberFormatException e) {
            try {
                for (int i = 0; i < datas.size(); i++) {
                    try {
                        Double.parseDouble(datas.get(i));
                    } catch (NullPointerException n) {

                    }
                }
                type = "double";
            } catch (NumberFormatException e2) {
                type = "String";
            }
        }
        return type;
    }


    @Override
    public String getHeader() {
        return null;
    }

    @Override
    public String getValue(int index) {
        return this.datas.get(index);
    }

    @Override
    public <T extends Number> T getValue(int index, Class<T> t) {
        return null;
    }

    @Override
    public void setValue(int index, String value) {
        this.datas.set(index,value);

    }

    @Override
    public <T extends Number> void setValue(int index, T value) {

    }

    @Override
    public int count() {
        return this.datas.size();
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
