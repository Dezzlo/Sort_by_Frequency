package sort_by_frequency_cource_3;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Задание : выполнить сортировку массива по частоте.
 *
 * @author Gorshkov Nikita , 16IT18K
 */
public class Sort_by_Frequency {
    public static void main(String args[]){

        ArrayList<Integer> array = new ArrayList<Integer>();
        Collections.addAll(array , 2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8);

        ArrayList<Integer> number_from_an_array = new ArrayList<Integer>(array.size());

            writing_numbers_in_ArrayList(number_from_an_array , array);

        int jabka_chest = number_from_an_array.size(); //Используется в одном неприметном цикле .. Хе хе хе

        ArrayList<Integer> frequency_of_number = new ArrayList<Integer>(number_from_an_array.size());

            finding_the_frequency_of_numbers(number_from_an_array , array , frequency_of_number);

            array.clear(); //Очищаем массив , для дальнейшего использования


        /**
         * Цикл с методом для поиска максимальной частоты, а также записи
         * сортировки в пустой ArrayList.
         *
         * Press F to respect за жабку.
         */
        for(int j = 0 ; j <= jabka_chest - 1 ; j++){
            max_frequency(frequency_of_number , number_from_an_array , array);
        }

        prosto_krasivo(array);
    }

    /**
     * Метод используется для поиска и записи частоты в ArrayList ( frequency_of_number - частота чисел ).
     */
    public static void finding_the_frequency_of_numbers(ArrayList<Integer> number_from_an_array ,
                                                        ArrayList<Integer> array ,
                                                        ArrayList<Integer> frequency_of_number){
        int frequency = 0;
        int variable_NFAA , variable_Array;

        for (int j = 0 ; j <= number_from_an_array.size() - 1 ; j++){
            variable_NFAA = number_from_an_array.get(j);

            for (int o = 0; o <= array.size() - 1; o++) {
                variable_Array = array.get(o);

                if(variable_NFAA == variable_Array){
                    frequency++;
                }

            }
            frequency_of_number.add(frequency);
            frequency = 0;
        }
    }

    /**
     * Метод используется для записи чисел в ArrayList ( number_from_an_array - числа для массива ).
     */
    public static void writing_numbers_in_ArrayList(ArrayList<Integer> number_from_an_array , ArrayList<Integer> array){
        for (int i = 0 ; i <= array.size() - 1; i++){
            if(number_from_an_array.contains(array.get(i))){
                continue;
            }
            else{
                number_from_an_array.add(array.get(i));
            }

        }
    }

    /**
     * Метод предназначен для поиска максимальной частоты, записи сортировки, а так же
     * удаление чисел 
     *
     * @param frequency_of_number
     * @param number_from_an_array
     * @param array
     */
    public static void max_frequency(ArrayList<Integer> frequency_of_number,
                                     ArrayList<Integer> number_from_an_array,
                                     ArrayList<Integer> array){
        int max_frequency = 0;
        int i_need_this_variable = 0;

        for (int i = 0 ; i <= frequency_of_number.size() - 1 ; i++){
            if (max_frequency < frequency_of_number.get(i)){
                max_frequency = frequency_of_number.get(i);

                i_need_this_variable = i;
            }
        }
        frequency_of_number.remove(i_need_this_variable);

        for (int j = 0 ; j <= max_frequency - 1; j++){
            array.add(number_from_an_array.get(i_need_this_variable));
        }

        number_from_an_array.remove(i_need_this_variable);
    }

    /**
     * Метод используется для показа ответа пользователю.
     *
     * @param array
     */
    public static void prosto_krasivo(ArrayList<Integer> array){
        System.out.print("{ ");
        for (Integer q : array){
            System.out.print(q + " ");
        }
        System.out.println("}");
    }

}
