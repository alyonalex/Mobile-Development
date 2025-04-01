**Отчёт по 1 практической работе**
----
Первым этапом в работе над данной практической работой стала установка среды разработки Android Studio. Далее был создан первый проект Lesson 1, в котором в дальнейшем создавались различные модули под каждое задание: layouttype, control_lesson1, buttonclicker.

Модуль layouttype
--
В модуле layouttype было создано несколько различных файлов типа "Layout resource file", в каждом из которых были реализованы различные виды макетов для построения интерфейса. Были созданы макеты с использованием LinearLayout (в вертикальной и горизонтальной ориентации), TableLayout и ConstraintLayout. Изучены разные виды элементов (текст, кнопки, чекбокс) и настройка параметров этих элементов через код. Изучен механизм привязки элементов к родительскому и к другим элементам макета с помощью графического редактора и ручного добавления констрейнтов.

**Макет с использованием LinearLayout:**

![2](https://github.com/user-attachments/assets/57209e37-bc8e-4aae-8798-83044441e8da)

**Макет с использованием TableLayout:**

![3](https://github.com/user-attachments/assets/091c0164-8467-4247-8ada-16253efa1eda)

**Макет с использованием ConstraintLayout, в котором необходимо было добавить несколько элементов и выполнить ручную привязку данных элементов через констрейнты:**

![4](https://github.com/user-attachments/assets/2bcc33a1-0d41-432c-954e-625350349bb6)

Модуль control_lesson1
--
В модуле control_lesson1 в главном файле activity_main.xml был создан макет с использованием следующих элементов: textView, plainText, button, imageButton, checkBox и imageview для (установки изображения).

**Готовый макет представлен ниже:**

![5](https://github.com/user-attachments/assets/fc6e51ca-e9b4-4d31-9028-86c653dc49e8)

Также был создан второй файл activity_second.xml, в который был добавлен макет, содержащий текстовое поле и 6 кнопок

![6](https://github.com/user-attachments/assets/36352328-5216-4a52-a85c-fe021f3a28fc)

Далее был создан альтернативный файл activity_second.xml (land) для альбомной ориентации, который позволяет настроить изменение ориентации приложения при повороте экрана в горизонтальное положение. Корректное отображение элементов в TableLayout было достигнуто путём программного связывания макета с activity через метод setContentView(R.layout.activity_second).

**Макет в горизонтальной ориентации**

![7](https://github.com/user-attachments/assets/07c65fa7-bc0f-4386-b1ca-9e98c7531eaf)

Модуль buttonclicker
--
В модуле buttonclicker в главном файле activity_main.xml был создан макет с использованием текстового поля, двух кнопок и чекбокса. Изменения свойств элементов были реализованы при помощи кода в файле MainActivity, а именно изменение текста в TextView с помощью метода setText() и установка состояния CheckBox через setChecked(true). Для каждой кнопки в коде был прописан обработчик событий, который позволяет выполнить определённое действие при клике на эту кнопку. При клике на кнопку "Who Am I" в текстовом поле появляется текст "Мой номер по списку № 15", а при клике по кнопке "It Is Not Me" - текст "Это сделал не я". 

![8](https://github.com/user-attachments/assets/fda70124-d7f9-4ce2-9b68-377302066676)

![9](https://github.com/user-attachments/assets/c168ef19-4a36-4766-802e-21817d3b0b28)

**Код файла MainActivity:**

```
package ru.mirea.krasikovaaa.buttonclicker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView tvOut;
    private Button btnWhoAmI;
    private Button btnItIsNotMe;
    private CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tvOut = findViewById(R.id.tvOut);
        btnWhoAmI = findViewById(R.id.btnWhoAmI);
        checkBox = findViewById(R.id.checkBox);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        View.OnClickListener oclBtnWhoAmI = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOut.setText("Мой номер по списку № 15");
            }
        };
        btnWhoAmI.setOnClickListener(oclBtnWhoAmI);
    }

    public void onMyButtonClick(View view) {
        boolean isChecked = !checkBox.isChecked();
        checkBox.setChecked(isChecked);

        if (isChecked) {
            tvOut.setText("Это не я сделал");
        } else {
            tvOut.setText("Мой номер по списку № 15");
        }

    }
}
```
Выводы
---
В процессе работы над данным заданием было проведено знакомство с ПО для разработки мобильных приложений под Android. Изучены принципы создания новых проектов и модулей в этих проектах. Были созданы тестовые проекты с использованием различных макетов и элементов интерфейса. Изучены принципы поддержки смены ориентации экрана, выполнено программное управление состоянием элементов и изучены два разных подхода в создании обработчиков событий для кнопок
