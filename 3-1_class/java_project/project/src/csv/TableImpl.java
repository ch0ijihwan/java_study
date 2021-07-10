package csv;


import java.util.*;
import java.util.function.Predicate;

import static java.lang.Float.NaN;

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
        int blank = 4; // 블랭크가 너무 작을 경우를 방지.


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
                } catch (NullPointerException e) {


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
                    } catch (NullPointerException e) {
                        t = t - 4;
                    }

                    String blank = make_blank(t);

                    if (col_zip.get(i).datas.get(j) == null && Head.header.get(i).length() < 4) {

                        System.out.printf(" %s%s |", blank, "null");

                    } else if (col_zip.get(i).datas.get(j) == null && Head.header.get(i).length() > 4) {

                        try {
                            System.out.printf(" %s%s |", blank.substring(0, blank.length()), "null");
                        } catch (StringIndexOutOfBoundsException w) {

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

    int count_cell(ColumnImpl c) {
        int count = 0;

        for (int i = 0; i < c.datas.size(); i++) {
            count++;
            try {

                double d = Double.parseDouble(c.datas.get(i));

                if (c.datas.get(i).equals(null)) {
                    count--;
                }


            } catch (NumberFormatException e1) {
                count--;
            } catch (NullPointerException e) {
                count--;
                continue;
            }
        }


        return count;
    }

    boolean all_String_check(String a) {
        try {
            Integer I = Integer.parseInt(a);
            Double D = Double.parseDouble(a);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }

    }

    @Override
    public Table getStats() {
        TableImpl n_table = new TableImpl();

        List<Integer> temp_head_index = new ArrayList();
        int null_count = 0;

        int string_count = 0;

        //틀 생성
        n_table.Head.header.add("          ");

        ColumnImpl base = new ColumnImpl();
        base.datas.add("count");
        base.datas.add("Mean");
        base.datas.add("std");
        base.datas.add("min");
        base.datas.add("25%");
        base.datas.add("50%");
        base.datas.add("75%");
        base.datas.add("max");

        n_table.col_zip.add(base);

        int double_count = 0;
        // 헤더 만들기

        for (int c = 0; c < this.col_zip.size(); c++) {
            string_count = 0;
            double_count = 0;

            for (int k = 0; k < this.col_zip.get(c).datas.size(); k++) {

                try {

                    Double d = Double.parseDouble(this.col_zip.get(c).datas.get(k));
                    double_count++;


                } catch (NumberFormatException e1) {

                    string_count++;
                    continue;
                } catch (NullPointerException e) {

                }
            }


            if (double_count > 0) {
                temp_head_index.add(c);
                n_table.Head.header.add(this.Head.header.get(c));
            } else {

            }

        }


        for (int i = 0; i < n_table.Head.header.size() - 1; i++) {
            ColumnImpl n_col = new ColumnImpl();
            n_col.datas.add(String.valueOf(count_cell(this.col_zip.get(temp_head_index.get(i)))));
            n_col.datas.add(String.valueOf(this.col_zip.get(temp_head_index.get(i)).getMean()));
            n_col.datas.add(String.valueOf(this.col_zip.get(temp_head_index.get(i)).getStd()));
            n_col.datas.add(String.valueOf(this.col_zip.get(temp_head_index.get(i)).getNumericMin()));
            n_col.datas.add(String.valueOf(this.col_zip.get(temp_head_index.get(i)).getQ1()));
            n_col.datas.add(String.valueOf(this.col_zip.get(temp_head_index.get(i)).getMedian()));
            n_col.datas.add(String.valueOf(this.col_zip.get(temp_head_index.get(i)).getQ3()));
            n_col.datas.add(String.valueOf(this.col_zip.get(temp_head_index.get(i)).getNumericMax()));
            n_table.col_zip.add(n_col);
        }

        System.out.println(n_table.col_zip);
        return n_table;


    }

    @Override
    public Table head() {

        TableImpl n_table = new TableImpl();

        n_table.Head.header = this.Head.header;


        List<String> temp = new ArrayList();


        for (int i = 0; i < this.col_zip.size(); i++) {

            ColumnImpl c = new ColumnImpl();

            for (int j = 0; j < 5; j++) {


                c.datas.add(this.col_zip.get(i).datas.get(j));

            }
            n_table.col_zip.add(c);


        }

        return n_table;
    }

    @Override
    public Table head(int lineCount) {
        TableImpl n_table = new TableImpl();

        n_table.Head.header = this.Head.header;


        List<String> temp = new ArrayList();


        for (int i = 0; i < this.col_zip.size(); i++) {

            ColumnImpl c = new ColumnImpl();

            for (int j = 0; j < lineCount; j++) {


                c.datas.add(this.col_zip.get(i).datas.get(j));

            }
            n_table.col_zip.add(c);


        }

        return n_table;

    }

    @Override
    public Table tail() {
        TableImpl n_table = new TableImpl();

        n_table.Head.header = this.Head.header;


        List<String> temp = new ArrayList();


        for (int i = 0; i < this.col_zip.size(); i++) {

            ColumnImpl c = new ColumnImpl();

            for (int j = 5; j > 0; j--) {


                c.datas.add(this.col_zip.get(i).datas.get(this.col_zip.get(0).datas.size() - j));

            }
            n_table.col_zip.add(c);


        }

        return n_table;
    }

    @Override
    public Table tail(int lineCount) {
        TableImpl n_table = new TableImpl();

        n_table.Head.header = this.Head.header;


        List<String> temp = new ArrayList();


        for (int i = 0; i < this.col_zip.size(); i++) {

            ColumnImpl c = new ColumnImpl();

            for (int k = lineCount; k > 0; k = k - 1) {


                c.datas.add(this.col_zip.get(i).datas.get(this.col_zip.get(0).datas.size() - k));

            }

            n_table.col_zip.add(c);


        }

        return n_table;
    }

    @Override
    public Table selectRows(int beginIndex, int endIndex) {
        TableImpl n_table = new TableImpl();
        n_table.Head.header = this.Head.header;
        List<String> temp = new ArrayList();

        for (int i = 0; i < this.col_zip.size(); i++) {

            ColumnImpl c = new ColumnImpl();

            for (int j = beginIndex; j < endIndex; j++) {
                c.datas.add(this.col_zip.get(i).datas.get(beginIndex + j));

            }
            n_table.col_zip.add(c);


        }

        return n_table;

    }

    @Override
    public Table selectRowsAt(int... indices) {
        TableImpl n_table = new TableImpl();

        n_table.Head.header = this.Head.header;

        List<String> temp = new ArrayList();


        for (int i = 0; i < this.col_zip.size(); i++) {

            ColumnImpl c = new ColumnImpl();

            for (int j = 0; j < indices.length; j++) {

                c.datas.add(this.col_zip.get(i).datas.get(indices[j] - 1));

            }
            n_table.col_zip.add(c);

        }

        return n_table;
    }

    @Override
    public Table selectColumns(int beginIndex, int endIndex) {
        TableImpl n_table = new TableImpl();

        //헤드 지정

        for (int i = beginIndex; i < endIndex; i++) {

            n_table.Head.header.add(this.Head.header.get(i));
        }


        for (int j = beginIndex; j < endIndex; j++) {

            ColumnImpl c = new ColumnImpl();

            for (int k = beginIndex; k < this.col_zip.get(j).datas.size(); k++) { //891번

                try {
                    c.datas.add(new String(col_zip.get(j).getValue(k)));
                } catch (NullPointerException e) {
                    c.datas.add(null);
                }

            }

            n_table.col_zip.add(c);
        }

        return n_table;
    }


    @Override
    public Table selectColumnsAt(int... indices) {
        TableImpl n_table = new TableImpl();

        //헤드 지정

        for (int i = 0; i < indices.length; i++) {

            n_table.Head.header.add(this.Head.header.get(indices[i]));
        }


        for (int j = 0; j < indices.length; j++) {

            ColumnImpl c = new ColumnImpl();

            for (int k = 0; k < this.col_zip.get(0).datas.size(); k++) { //891번

                try {
                    c.datas.add(new String(col_zip.get(indices[j]).getValue(k)));
                } catch (NullPointerException e) {
                    c.datas.add(null);
                }

            }

            n_table.col_zip.add(c);
        }

        return n_table;

    }

    @Override
    public <T> Table selectRowsBy(String columnName, Predicate<T> predicate) {


        List<Integer> list = new ArrayList<>();

        //(String x) -> x.contains("Lee")  = predicate
        int index = 0;
        String temp = "";


        System.out.println(this.Head.header);


        for (int k = 0; k < this.Head.header.size(); k++) {

            if (this.Head.header.get(k).equals(columnName)) {
                index = k;
            }
        }

        System.out.println("index = " + index);


        for (int j = 0; j < this.col_zip.get(index).datas.size(); j++) {

            if (this.col_zip.get(index).check_type(this.col_zip.get(index)).equals("String")) {


                T t = (T) this.col_zip.get(index).datas.get(j);


                try {
                    if (predicate.test(t) & !this.col_zip.get(index).datas.get(j).equals(null)) {
                        list.add(j);
                    }

                } catch (NullPointerException e3) {
                    continue;
                }

            } else if (this.col_zip.get(index).check_type(this.col_zip.get(index)).equals("double")) {


                try {
                    Double i = Double.parseDouble(this.col_zip.get(index).datas.get(j));
                    T t = (T) i;

                    try {
                        if (predicate.test(t)) {


                            list.add(j);

                        }
                    } catch (NullPointerException e1) {


                    }

                } catch (NumberFormatException e) {
                    continue;
                }


            }


        }

        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        System.out.println(list);

        int[] result = arr;
        return selectRowsAt(arr);
    }


    @Override
    public Table sort(int byIndexOfColumn, boolean isAscending, boolean isNullFirst) {

        List<Integer> list = new ArrayList<>();
        List<Integer> null_list_zip = new ArrayList<>();
        int[] arr = new int[this.col_zip.get(byIndexOfColumn).datas.size()];
        List<Integer> result_index = new ArrayList<>();

        String temp;
//방법 1. 널부분의 인덱스를 따로 뺀다. 2. 남은 인덱스들을 콜렉션으로 정렬. 3. col 임시객체를 생성하고 datas   복사. 4. 정렬한 후 이퀄즈로 col과 정렬한 리스트를 비교하고 같으면, ....으로 치환. 5.헤더를 제외한ㅇ ㅣㄴ덱스라 +1 해주고
// 아까 나웠던 리스트를 합침. 정렬 리스트와 널리스트 합치기
// // 이후 리턴~

        for(int i = 0 ; i < this.col_zip.get(byIndexOfColumn).datas.size();i++){

            try {


                if(this.col_zip.get(byIndexOfColumn).datas.get(i).equals(null)){

                }
                list.add(i);


            }catch (NullPointerException e){
                null_list_zip.add(i);
                continue;
            }

        }


        System.out.println(list);
        System.out.println(null_list_zip);
        ColumnImpl col = new ColumnImpl();

        List< String> before_sorting = new ArrayList<>();

        if(this.col_zip.get(byIndexOfColumn).check_type(this.col_zip.get(byIndexOfColumn)).equals("double")){//더블



            for(int i = 0; i< list.size();i++){

                  before_sorting.add(this.col_zip.get(byIndexOfColumn).datas.get(list.get(i)));

            }
            //sort를 위한 Double 변환

            List<Double> D_temp = new ArrayList<>();


            for(int j = 0; j<before_sorting.size();j++){
                D_temp.add(Double.parseDouble(before_sorting.get(j)));
            }

            Collections.sort(D_temp);
            System.out.println("before"+before_sorting);

            System.out.println("after"+D_temp);





            for(int o = 0; o < this.col_zip.get(byIndexOfColumn).datas.size();o++){//임시 data 생성
                try  {
                    col.datas.add(String.valueOf(Double.parseDouble(this.col_zip.get(byIndexOfColumn).datas.get(o))));
                }
                catch (NullPointerException e){
                    col.datas.add(null);
                }

            }

            for(int k = 0; k<D_temp.size();k++){

               Double d = D_temp.get(k);
               String s = String.valueOf(d);
               int temp_in = col.datas.indexOf(s);
               result_index.add( temp_in +1);
               col.datas.set( temp_in,null);

            }

            List<Integer> joined = new ArrayList<>();


            for(int i = 0 ; i<result_index.size();i++){
                joined.add(result_index.get(i));
            }

            for(int i = 0 ; i<null_list_zip.size();i++){
                joined.add(null_list_zip.get(i));
            }



            int [] temp_arr = new int [joined.size()] ;


                for(int i =0; i<joined.size();i++){
                    temp_arr[i] = joined.get(i);
                }


                return (TableImpl) selectRowsAt(temp_arr);






        }
        else if(this.col_zip.get(byIndexOfColumn).check_type(this.col_zip.get(byIndexOfColumn)).equals("int")){//인트

        }
        else{ //string

        }
















        return null;

    }

    @Override
    public Table shuffle() {
        TableImpl new_table = this;

        TableImpl temp_new_table = new TableImpl();
        temp_new_table.Head.header = this.Head.header;


        ColumnImpl c = new ColumnImpl();


        Collections.shuffle(new_table.temp_data);

        System.out.println(new_table.temp_data);

        this.col_zip.clear();
        for (int i = 0; i < this.temp_data.get(0).size(); i++) {
            ColumnImpl co = new ColumnImpl();


            for (int j = 0; j < this.temp_data.size(); j++) {
                co.datas.add(this.temp_data.get(j).get(i));

            }


            this.col_zip.add(co);
        }


        return this;
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {


        return this.col_zip.size();
    }

    @Override
    public Column getColumn(int index) {


        return this.col_zip.get(index);
    }

    @Override
    public Column getColumn(String name) {
        return null;
    }

    @Override
    public boolean fillNullWithMean() {

        Boolean[] check_index = new Boolean[col_zip.size()];

        for (int i = 0; i < this.col_zip.size(); i++) {
            check_index[i] = this.col_zip.get(i).fillNullWithMean();
        }

        for (int i = 0; i < check_index.length; i++) {
            if (check_index[i] == true) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean fillNullWithZero() {

        this.col_zip.clear();
        boolean re_ = false;

        for (int i = 0; i < this.temp_data.get(0).size(); i++) {
            ColumnImpl c = new ColumnImpl();


            for (int j = 0; j < this.temp_data.size(); j++) {

                try {
                    if (this.temp_data.get(j).get(i).equals(null)) {

                    } else {
                        c.datas.add(this.temp_data.get(j).get(i));
                    }
                } catch (NullPointerException e) {

                    c.datas.add("0");
                    re_ = true;
                    continue;
                }

            }

            this.col_zip.add(c);
        }

        return (re_ == true) ? true : false;
    }

    @Override
    public boolean standardize() {
        List<Integer> temp_head_index = new ArrayList();
        int null_count = 0;

        int string_count = 0;
        int double_count = 0;
        // 헤더 만들기

        for (int c = 0; c < this.col_zip.size(); c++) {
            string_count = 0;
            double_count = 0;

            for (int k = 0; k < this.col_zip.get(c).datas.size(); k++) {

                try {

                    Double d = Double.parseDouble(this.col_zip.get(c).datas.get(k));
                    double_count++;


                } catch (NumberFormatException e1) {
                    continue;
                } catch (NullPointerException e) {

                }
            }


            if (double_count > 0) {
                temp_head_index.add(c);
            } else {

            }

        }


        /// 시작


        System.out.println(temp_head_index);
        boolean count_cal = false;

        ColumnImpl c = new ColumnImpl();

        for (int j = 0; j < temp_head_index.size(); j++) {


            double mean = this.col_zip.get(temp_head_index.get(j)).getMean();
            double std = this.col_zip.get(temp_head_index.get(j)).getStd();
            for (int i = 0; i < this.col_zip.get(temp_head_index.get(j)).datas.size(); i++) {
                try {
                    try {
                        double number = Double.parseDouble(this.col_zip.get(temp_head_index.get(j)).datas.get(i));

                        number = Math.round(number * 1000000.0) / 1000000.0;
                        number = (number - mean) / std;
                        number = Math.round(number * 1000000.0) / 1000000.0;

                        this.col_zip.get(temp_head_index.get(j)).datas.set(i, Double.toString(number));

                    } catch (NumberFormatException e1) {
                        continue;
                    }

                } catch (NullPointerException e) {
                    continue;

                }
                count_cal = true;
            }


        }


        System.out.println(this.col_zip.get(0).datas);

        return count_cal ? true : false;
    }

    @Override
    public boolean normalize() {

        List<Integer> temp_head_index = new ArrayList();
        int null_count = 0;

        int string_count = 0;
        int double_count = 0;
        // 헤더 만들기

        for (int c = 0; c < this.col_zip.size(); c++) {


            string_count = 0;
            double_count = 0;

            for (int k = 0; k < this.col_zip.get(c).datas.size(); k++) {

                try {

                    Double d = Double.parseDouble(this.col_zip.get(c).datas.get(k));
                    double_count++;


                } catch (NumberFormatException e1) {
                    continue;
                } catch (NullPointerException e) {

                }
            }


            if (double_count > 0) {
                temp_head_index.add(c);
            } else {

            }

        }


        /// 시작


        System.out.println(temp_head_index);
        boolean count_cal = false;

        ColumnImpl c = new ColumnImpl();

        for (int j = 0; j < temp_head_index.size(); j++) {


            double min = this.col_zip.get(temp_head_index.get(j)).getNumericMin();
            double max = this.col_zip.get(temp_head_index.get(j)).getNumericMax();
            for (int i = 0; i < this.col_zip.get(temp_head_index.get(j)).datas.size(); i++) {
                try {
                    try {
                        double number = Double.parseDouble(this.col_zip.get(temp_head_index.get(j)).datas.get(i));

                        number = Math.round(number * 1000000.0) / 1000000.0;
                        number = (number - min) / (max - min);
                        number = Math.round(number * 100.0) / 100.0;

                        this.col_zip.get(temp_head_index.get(j)).datas.set(i, Double.toString(number));

                    } catch (NumberFormatException e1) {
                        continue;
                    }

                } catch (NullPointerException e) {
                    continue;

                }
                count_cal = true;
            }


        }


        System.out.println(this.col_zip.get(0).datas);

        return count_cal ? true : false;

    }

    @Override
    public boolean factorize() {

        Boolean re_count = false;


        for (int i = 0; i < this.col_zip.size(); i++) {

            HashSet<String> set = new HashSet<>();

            for (int j = 0; j < this.col_zip.get(i).datas.size(); j++) {

                set.add(this.col_zip.get(i).datas.get(j));

            }

            if (set.size() == 2) {


                String temp = "";
                temp = this.col_zip.get(i).datas.get(0);
                for (int k = 0; k < this.col_zip.get(i).datas.size(); k++) {

                    if (!temp.equals(this.col_zip.get(i).datas.get(k))) {
                        this.col_zip.get(i).datas.set(k, "1");

                    } else {
                        this.col_zip.get(i).datas.set(k, "0");
                    }


                    if (re_count == false) {
                        re_count = true;
                    }

                }

            }

        }


        return re_count ? true : false;
    }
}

