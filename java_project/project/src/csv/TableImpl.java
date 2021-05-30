package csv;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class TableImpl implements Table {

    List<ColumnImpl> col_zip = new ArrayList<ColumnImpl>();

    List<List<String>> values = new ArrayList<List<String>>(); // 값을 넣어줄 리스트
    List<List<String>> temp_data = new ArrayList<List<String>>(); //print를 사용하기 위한 임시 공간.

    ColumnImpl Head = new ColumnImpl();//헤드 넣어줄 col

    boolean isheader_on = true;


    @Override
    public String toString() {
        System.out.println("<csv.Table" + "@" + Integer.toHexString(hashCode()) + ">");
        if (this.isheader_on == true) {
            System.out.println("RangeIndex: " + (this.temp_data.size()) + " entries, 0 to " + (this.temp_data.size() - 1));
        } else {
            System.out.println("RangeIndex: " + (this.temp_data.size() - 0) + " entries, 0 to " + (this.temp_data.size() - 1));
        }
        System.out.println("Data columns (total " + this.col_zip.size() + " columns):");

        System.out.printf("%4s |%20s | %20s | %8s\n", "#", "Column", "Non_Null Count", "Dtype");

        int cnt_d = 0, cnt_s = 0, cnt_i = 0;
        for (int i = 0; i < col_zip.size(); i++) {
            String temp = Integer.toString(col_zip.get(i).Non_Null_cnt) + " non_null";
            if (isheader_on == true) {

                System.out.printf("%4s |%20s | %20s | %8s\n", i, this.Head.header.get(i), temp, col_zip.get(i).Data_Type);
            } else {
                System.out.printf("%4s |%20s | %20s | %8s\n", i, col_zip.get(i).datas.get(0), temp, col_zip.get(i).Data_Type);
            }
            if (this.col_zip.get(i).Data_Type.equals("String")) {
                cnt_s++;
            } else if (this.col_zip.get(i).Data_Type.equals("double")) {
                cnt_d++;
            } else if (this.col_zip.get(i).Data_Type.equals("int")) {
                cnt_i++;
            }
        }
        ;
        System.out.printf("dtypes: double(%d), int(%d), String(%d)\n", cnt_d, cnt_i, cnt_s);
        return "";
    }


    String make_blank(int w) {

        String blank = "";

        for (int i = 0; i < w; i++) {
            blank = blank + " ";
        }

        return blank;
    }


    int count_blank(int t) {
        int blank = 0;


        if (this.isheader_on) {


            for (int i = 0; i < col_zip.get(t).datas.size(); i++) {
                try {
                    if (blank < col_zip.get(t).datas.get(i).length() || blank < Head.header.get(t).length()) { //header의 값과 col데이터 테이블 각을 각각 비교 해서  둘중 큰 것을 리턴.
                        if (col_zip.get(t).datas.get(i).length() < Head.header.get(t).length())
                            blank = Head.header.get(t).length();
                        else {
                            blank = col_zip.get(t).datas.get(i).length();
                        }
                    }
                }
                catch (NullPointerException e){




                }
            }
            return blank;
        } else {
            for (int i = 0; i < col_zip.get(t).datas.size(); i++) {
                if (blank < col_zip.get(t).datas.get(i).length()) { //header의 값과 col데이터 테이블 각을 각각 비교 해서  둘중 큰 것을 리턴.

                    blank = col_zip.get(t).datas.get(i).length();
                }
            }
            return blank;

        }
    }


    @Override
    public void print() {
//        if(this.isheader_on == true) {
//            for (int i = 0; i < col_zip.size(); i++) {
//                col_zip.get(i).print_Head(i);
//            }
//            System.out.println();
//        }
//
//        for(int i=0; i<col_zip.get(0).datas.size(); i++){
//            for(int j=0; j<col_zip.size(); j++) {
//                col_zip.get(j).print(i);
//            }
//            System.out.println();
//        }
        if (this.isheader_on == true) {
            for (int j = 0; j < Head.header.size(); j++) {
                int t = count_blank(j);
                t = t - Head.header.get(j).length();
                String blank = make_blank(t);


                System.out.printf(" %s%s |", blank, Head.header.get(j));
            }

            System.out.println();

            for (int j = 0; j < col_zip.get(0).datas.size(); j++) {
                for (int i = 0; i < col_zip.size(); i++) {
                    int t = count_blank(i);
                    try {
                        t = t - col_zip.get(i).datas.get(j).length();
                    }
                    catch (NullPointerException e){
                            t = t-4;
                    }

                    String blank = make_blank(t);

                    if (col_zip.get(i).datas.get(j) == null && Head.header.get(i).length() < 4) {

                        System.out.printf(" %s%s |", blank, "null");

                    } else if (col_zip.get(i).datas.get(j) == null && Head.header.get(i).length() > 4) {

                        try {
                            System.out.printf(" %s%s |", blank.substring(0, blank.length()), "null");
                        }
                        catch (StringIndexOutOfBoundsException w){

                        }
                    } else {

                        System.out.printf(" %s%s |", blank, col_zip.get(i).datas.get(j));
                    }
                }
                System.out.println();
            }
        } else {
            for (int j = 1; j < col_zip.get(0).datas.size(); j++) {
                for (int i = 0; i < col_zip.size(); i++) {
                    int t = count_blank(i);
                    t = t - col_zip.get(i).datas.get(j).length();
                    String blank = make_blank(t);
                    System.out.printf("% s%s |", blank, col_zip.get(i).datas.get(j));
                }
                System.out.println();
            }
        }


    }



    @Override
    public Table getStats() {

        return null;
    }

    @Override
    public Table head() {
        return null;
    }

    @Override
    public Table head(int lineCount) {
        return null;
    }

    @Override
    public Table tail() {
        return null;
    }

    @Override
    public Table tail(int lineCount) {
        return null;
    }

    @Override
    public Table selectRows(int beginIndex, int endIndex) {
        return null;
    }

    @Override
    public Table selectRowsAt(int... indices) {
        return null;
    }

    @Override
    public Table selectColumns(int beginIndex, int endIndex) {
        return null;
    }

    @Override
    public Table selectColumnsAt(int... indices) {
        return null;
    }

    @Override
    public <T> Table selectRowsBy(String columnName, Predicate<T> predicate) {
        return null;
    }

    @Override
    public Table sort(int byIndexOfColumn, boolean isAscending, boolean isNullFirst) {
        return null;
    }

    @Override
    public Table shuffle() {
        return null;
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Column getColumn(int index) {
        return null;
    }

    @Override
    public Column getColumn(String name) {
        return null;
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
