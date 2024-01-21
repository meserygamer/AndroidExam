package API

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Объект хранящий подключение retrofit
object APIConnection {

    //Свойство для получения подключения retrofit, если оно создано возвращает старое,
    // если не создано, то создает новое
    val retrofitConnection : Retrofit
        get() {
            if(_retrofitConnection == null) //Если ещё не создан, то создаем
            {
                _retrofitConnection = Retrofit.Builder() //Начинаем сборку соединения
                                              .baseUrl(_baseURI) //Задаем базовый адрес API
                                              .addConverterFactory(GsonConverterFactory.create(gson))
                                              //Создаем фабрику преобразования в Json
                                              .build() //Завершаем сборку и получаем объект Retrofit
            }
            return _retrofitConnection!!
        }

    //Свойство для связи соединения retrofit с написанным интерфейсом
    val retrofitConnectionWithInterface : IAPIConnectionInterface
        get() = retrofitConnection.create(IAPIConnectionInterface::class.java)

    //Свойство хранящее email пользователя, по умолчанию null
    var UserEmail : String? = null;


    //Свойство хранящее адрес сервера
    private val _baseURI = "https://iis.ngknn.ru/NGKNN/%D0%9C%D0%B0%D0%BC%D1%88%D0%B5%D0%B2%D0%B0%D0%AE%D0%A1/exam/";

    //Свойство хранящее параметры создания Json документа из ответа сервера на запрос
    private val gson = GsonBuilder().setLenient()
                                    .create()

    //Свойство хранящее объект retrofit, если он ещё не создан, значение равно null
    private var _retrofitConnection : Retrofit? = null;

}

