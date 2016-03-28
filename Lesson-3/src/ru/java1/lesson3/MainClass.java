package ru.java1.lesson3;

/**
 * Created by Abilis on 26.03.2016.
 */
public class MainClass {

    public static void main(String[] args) {

        //192.168.100.10
        int ipAddress = 192; //записываем в интеджер число 192 (11 000 000)
        ipAddress = ipAddress << 8; //сдвигаем биты на 8 разрядов влево

        ipAddress += 168; //добавляем в исходный интеджер 168 ( 10 101 000)
        ipAddress = ipAddress << 8; //сдвигаем биты еще на 8 разрядов влево

        ipAddress += 100; //добавляем в исходный интеджер 100 (01 100 100)
        ipAddress = ipAddress << 8; //сдвигаем биты еще на 8 разрядов влево
        ipAddress += 10; //добавляем в исходный интеджер еще 10 (00 001 010)

        System.out.println(ipAddress + " - так записан 192.168.100.10, \"упакованный\" в один интеджер"); //что теперь записано в ipAddress
        String ipAddressAsStr = Integer.toBinaryString(ipAddress); //в двоичном виде

        //если длина получившейся строки меньше 32, то заполняем начало нулями, чтобы не было экспепшена при отображениии
        while (ipAddressAsStr.length() < 32) {
            ipAddressAsStr = "0" + ipAddressAsStr;
        }

        String firstOctet = ipAddressAsStr.substring(0, 8);
        String secondOctet = ipAddressAsStr.substring(8, 16);
        String thirdOctet = ipAddressAsStr.substring(16, 24);
        String fourthOctet = ipAddressAsStr.substring(24, 32);

        //строковое представление в двоичном виде
        System.out.println(firstOctet + "." + secondOctet + "." + thirdOctet + "." + fourthOctet + " - так он выглядит внутри, только без точек");

        System.out.println();

        //Восстанавливаем IP-адрес из интеджера
        int fourthOctetInt = ipAddress & 255; //должен получиться последний октет
        int thirdOctetInt = (ipAddress >> 8) & 255; //сдвигаем исходный интеджер на 8 бит вправо и вытаскиваем 3 октет
        int secondOctetInt = (ipAddress >> 16) & 255; //сдвигаем исходный интеджер на 16 бит вправо и вытаскиваем 2 октет
        int firstOctetInt = (ipAddress >> 24) & 255; //сдвигаем исходный интеджер на 24 бита вправо и вытаскиваем 1 октет

        //смотрим что получилось
        System.out.println(firstOctetInt + "." + secondOctetInt + "." + thirdOctetInt + "." + fourthOctetInt + " - востановленный адрес");

    }

}
