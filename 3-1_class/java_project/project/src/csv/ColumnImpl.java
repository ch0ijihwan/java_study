package csv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ColumnImpl implements Column {




    List<String> header = new ArrayList<>();

    List<String> datas = new ArrayList<String>();//col 데이터를 스트링 타입으로 넣어줌.


    List<Integer> tmp_index_a = new ArrayList<>();

    String Data_Type = ""; //데이터 타입을 반환하기위한 스티링 선언.
    int Non_Null_cnt;




    void check_non_null_cnt(ColumnImpl c) {
        c.Non_Null_cnt = 0;


        for (int i = 0; i < c.datas.size(); i++) {
            try {
                if (!c.datas.get(i).equals(null)) {
                    c.Non_Null_cnt += 1;
                }
            } catch (NullPointerException e) {
                continue;
            }
        }


    }


    String check_type(ColumnImpl column) {
        String type = "int";
        try {
            for (int i = 0; i < this.datas.size(); i++) {
                Integer.parseInt(this.datas.get(i));

            }
        } catch (NumberFormatException e) {
            try {
                for (int i = 0; i < this.datas.size(); i++) {
                    try {
                        Double.parseDouble(datas.get(i));
                    } catch (NullPointerException n) {
                        continue;
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
        this.datas.set(index, value);

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

        int count = 0;

        for (int i = 0; i < this.datas.size(); i++) {

            try {
                this.datas.get(i).equals(null);
            } catch (NullPointerException e) {
                count++;
            }
        }
        return count;
    }

    @Override
    public long getNumericCount() {
        return 0;
    }


    Boolean select_Integer(){

        for(int i = 0; i<datas.size(); i++){

            try {
                Integer.parseInt( datas.get(i) );
            }catch (NumberFormatException e ){
                return  true;
            }

        }

        return  false;
    }

    @Override
    public double getNumericMin() {


        double min_Value = 999999999;


        for (int i = 0; i < datas.size(); i++) {
            try {
                Double D = Double.parseDouble(datas.get(i));
                if (min_Value > D) {
                    min_Value = D;
                }
            } catch (NullPointerException e) {
                continue;
            } catch (NumberFormatException e1) {

            }
        }


        return min_Value;
    }

    @Override
    public double getNumericMax() {
        double max_Value = 0;


        for (int i = 0; i < datas.size(); i++) {
            try {
                Double D = Double.parseDouble(datas.get(i));
                if (max_Value < D)
                    max_Value = D;
            } catch (NullPointerException e) {
                continue;
            } catch (NumberFormatException e1) {

            }
        }


        return max_Value;


    }


    @Override
    public double getMean() {
        double mean_value = 0;
        double count = 0;

        for (int i = 0; i < datas.size(); i++) {
            try {
                if (datas.get(i).equals(null) == false)
                    count++;
            } catch (NullPointerException e) {
            }
        }

        for (int i = 0; i < datas.size(); i++) {
            try {
                mean_value = mean_value + Math.round(Double.parseDouble(datas.get(i))*1000000.0)/1000000.0;
            } catch (NullPointerException e) {

            } catch (NumberFormatException e1) {

            }
        }
        mean_value = mean_value / count;

        return Math.round( mean_value*1000000.0)/1000000.0;

    }


    @Override
    public double getStd() {
        double mean = getMean();

        double dev = 0;

        for (int i = 0; i < datas.size(); i++) {
            try {
                Double num = Double.parseDouble(datas.get(i)) - mean;


                dev =  dev + num * num;

            } catch (NullPointerException e) {
                continue;
            } catch (NumberFormatException e1) {
                continue;
            }
        }

        dev =  dev / Double.parseDouble(String.valueOf(datas.size()));

        dev = Math.sqrt(dev);

        return Math.round(dev*1000000.0)/1000000.0;

    }

    @Override
    public double getQ1() {

        List<Double> tmp_list = new ArrayList<>();

        for (int i = 0; i < datas.size(); i++) {
            try {
                Double d = Double.parseDouble(datas.get(i));
                tmp_list.add(d);
            } catch (NullPointerException e) {
                continue;

            } catch (NumberFormatException e1) {
                continue;
            }
        }

        Collections.sort(tmp_list);




        return  tmp_list.get(tmp_list.size() / 4 );
    }

    @Override
    public double getMedian() {


        List<Double> tmp_list = new ArrayList<>();

        for (int i = 0; i < datas.size(); i++) {
            try {
                Double d = Double.parseDouble(datas.get(i));
                tmp_list.add(d);
            } catch (NullPointerException e) {
                continue;

            } catch (NumberFormatException e1) {
                continue;
            }
        }

        Collections.sort(tmp_list);

        return tmp_list.get(tmp_list.size() / 2);

    }

    @Override
    public double getQ3() {

        List<Double> tmp_list = new ArrayList<>();

        for (int i = 0; i < datas.size(); i++) {
            try {
                Double d = Double.parseDouble(datas.get(i));
                tmp_list.add(d);
            } catch (NullPointerException e) {
                continue;

            } catch (NumberFormatException e1) {
                continue;
            }
        }

        Collections.sort(tmp_list);

        return tmp_list.get((tmp_list.size() / 2) + (tmp_list.size() / 4));
    }

    @Override
    public boolean fillNullWithMean() {
        String Dtype = Data_Type;

        if (Dtype.equals("String") == false) {
            double mean_value = getMean();

            for (int i = 0; i < this.datas.size(); i++) {

                try {
                    if (this.datas.get(i).equals(null)) {//널이라면

                        datas.set(i, Double.toString(mean_value));//평균값 넣기.
                    }
                } catch (NullPointerException e) {
                    datas.set(i, Double.toString(mean_value));
                }
            }

            return true;
        }
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

