Отчёт по 6 практической работе
----
В рамках данной практической работы были изучены различные способы хранения данных в OS Android: хранение через специальный файл настроек с использованием класса «SharedPreferences», хранение файлов во внутреннем и внешнем хранилище. Также рассмотрена работа с базой данных SQLite.

Задание №1: Хранение данных через файл настроек
---
В основном модуле проекта «app» в файле разметки было добавлено три поля ввода текста и кнопка. В файле «MainActivity» реализовано сохранение введённых данных через getSharedPreferences и их последующая загрузка в соответствующие поля при запуске приложения. Через «Device Explorer» был просмотрен файл настроек, в котором появился новый файл с полученными данными. Сделан скриншот экрана со значениями файла, скриншот размещён в директории «raw».

**Приложение после запуска:**

![1](https://github.com/user-attachments/assets/9c006a7d-a55b-4fa2-88b6-1871e10f2e24)

**Заполнение полей данными:**

![2](https://github.com/user-attachments/assets/93b06acc-7797-451b-8866-a909ca544193)

**Просмотр «Device Explorer»:**

![3](https://github.com/user-attachments/assets/f7522548-49d4-4f60-b1c6-80cedda9b8bc)

**Содержимое файла совпадает с введёнными данными:**

![4](https://github.com/user-attachments/assets/442a4ffb-c1b3-4cd3-9375-281903c9b426)

**После перезапуска приложения данные автоматически подставляются в соответствующие поля:**

![5](https://github.com/user-attachments/assets/d3069911-7d94-4ed4-84bf-55f2d0d0aee1)

Задание №2: использования «SharedPreferences»
-----
Для работы был создан новый модуль «SecureSharedPreferences». В файле разметки было добавлено поле ImageView, текстовое поле и кнопка для сохранения данных. В «gradle»-файл модуля добавлены новые зависимости. В файле «MainActivity» реализован механизм создания мастер-ключа и шифрования данных AES256. Сделан скриншот экрана со значениями полученного файла, скриншот размещён в директории «raw».

**Приложение после запуска:**

![6](https://github.com/user-attachments/assets/0ea67a53-fd33-4f35-9bf1-8648ff8bd338)

**Просмотр «Device Explorer»:**

![7](https://github.com/user-attachments/assets/eeab9c2a-acf5-4420-b521-6556721be7e4)

**Содержимое сохранённого файла:**

![8](https://github.com/user-attachments/assets/232cb04c-d175-4b4f-b521-4dccbee5b8cc)

Задание №3: Запись файлов во внутреннее хранилище
-----
Для работы был создан новый модуль «InternalFileStorage». В файле разметки добавлено поле для ввода текста и кнопка. В «MainActivity» реализована логика записи данных, введённых пользоватлем во внутреннее хранилище. Полученный файл перенесён в директорию проекта raw.

**Внешний вид приложения после запуска:**

![9](https://github.com/user-attachments/assets/d6dc07d7-00ea-4640-8776-6f4cfbe14d57)

**После заполнения поля данными и нажатия на кнопку данные сохраняются в файл, выводится соответствующее сообщение:**

![10](https://github.com/user-attachments/assets/8616c1bc-8052-4fa2-b484-40787a355bf8)

**Просмотр «Device Explorer»:**

![11](https://github.com/user-attachments/assets/5157a3c5-e9c7-41d4-990a-0e80862a7bc2)

**Содержимое сохранённого файла:**

![12](https://github.com/user-attachments/assets/4d769b26-febd-4266-ab46-df00f7c9599c)

**Файл перенесён в директорию raw соответствующего модуля:**

![13](https://github.com/user-attachments/assets/b79db618-45c3-4926-a0a4-7fe1d4b63520)

Задание №4: Запись файлов во внешнее хранилище
-----
Был создан новый модуль «Notebook». В файле разметки activity_main.xml было добавлено два поля для ввода текста (названия файла и цитата) и две кнопки для сохранения и загрузки сохранённых данных. В файле MainActivity реализована логика записи полученных данных в общедоступную директорию Documents с перезаписью существующих файлов. Создано два файла с цитатами известных личностей. Полученные файлы перенесены в директорию проекта raw.

**После заполнения полей данными и нажатия на кнопку данные сохраняются в файл, выводится соответствующее сообщение:**

![14](https://github.com/user-attachments/assets/29a3c6d2-4b56-45d9-a590-b9bd34fcdb29)

**Для наглядности можно очистить поле, в котором записывается цитата и затем нажать на кнопку "загрузить данные из файла", данные автоматически подставятся в нужное поле:**

![15](https://github.com/user-attachments/assets/483fe3a0-09bd-42fc-b417-e2d763ac2f35)
![16](https://github.com/user-attachments/assets/e739991a-9e2e-48a9-bbbe-e1281d040497)

**Заполнение данными и сохранение второго файла:**

![17](https://github.com/user-attachments/assets/c80c1c8a-e151-46fa-a2b1-36faac080ac0)

**Загрузка второго файла:**

![19](https://github.com/user-attachments/assets/78fff931-d767-4380-b670-505f6a6b5181)

**Просмотр «Device Explorer»:**

![20](https://github.com/user-attachments/assets/2696011b-0e1e-4773-a6f8-c07dea2a888c)

**Файлы перенесены в директорию raw соответствующего модуля:**

![21](https://github.com/user-attachments/assets/0820b142-f58d-4153-ad22-b4f5f503aced)

Задание №5: работа с базой данных SQLite
-----
Был создан новый модуль «EmployeeDB». В файле разметки activity_main.xml было добавлено текстовое поле и компонент ListView для отображения списка данных из БД. Созданы дополнительные файлы: файл Superhero.java, реализующий класс-сущность для создания таблицы, файл SuperheroDAO.java, реализующий интерфейс DAO с методами CRUD, файл AppDatabase.java, реализующий класс базы данных. Создан класс Application для инициализации БД. В файле MainActivity реализована логика создания БД через созданный Application, заполнение тестовыми данными и вывод полученных данных в соответствующий компонент (список).

**Список данных, полученный из БД:**

![22](https://github.com/user-attachments/assets/313f605b-b4df-4faa-a4df-ea77840d36ad)

Контрольное задание: добавление фрагментов «Профиль» и «Работа с файлами» в MireaProject
-----
1. В приложение был добавлен новый фрагмент ProfileFragment. В файл разметки добавлено несколько полей ввода текста (имя, возраст, группа и номер по списку) и кнопка для сохранения данных. Реализована логика сохранения введённых данных в файл настроек.
2. В приложение был добавлен новый фрагмент WorkingWithFilesFragment. В файле разметки добавлена кнопка «Floating Action Button» и текстовое поле для отображения всех сохранённых файлов. Также дополнительно создан FileDialogFragment, в нём реализована логика вывода окошка с полями для ввода текста (название файла, содержимое файла) и двумя кнопками (сохранить и отменить), которое появляется после нажатия на кнопку «Floating Action Button» на основном экране. Реализована логика простой «криптографии» и сохранения полученных данных во внутреннее хранилище.
   
**Меню со всеми вкладками:**

![23](https://github.com/user-attachments/assets/399948ec-33f4-4847-9c02-dcbff8ed5754)

**Экран «Профиль»:**

![24](https://github.com/user-attachments/assets/cc9c4efc-6b1e-49e8-9335-17e2e6be1461)

**После заполнения всех полей и нажатия на кнопку данные сохраняются в файл:**

![25](https://github.com/user-attachments/assets/12878c37-1a7c-4527-adb9-82e170939c12)

**Просмотр «Device Explorer»:**

![26](https://github.com/user-attachments/assets/a40e444c-0136-46eb-940d-32032aa07e61)

**Содержимое сохранённого файла совпадает с введёнными данными:**

![27](https://github.com/user-attachments/assets/f8d9f38b-8e93-447c-8ee1-d73b9d474176)

**Экран для работы с файлами, по нажатию на кнопку "+" появляется окошко с полями для ввода данных:**

![29](https://github.com/user-attachments/assets/638b833b-55b5-4de6-b89d-61a0704a93ae)

**После нажатия на кнопку «Сохранить» данные сохраняются в файл и название файла появляется в общем списке:**

![image](https://github.com/user-attachments/assets/ae3903f8-042a-4ca6-9b59-fbebaecf913d)

**Просмотр «Device Explorer»:**

![31](https://github.com/user-attachments/assets/f137adab-ca9b-4605-8919-36c8a6b8fd86)

**Данные в файле зашифрованы:**

![32](https://github.com/user-attachments/assets/ce9c70b4-a960-49d3-8498-72e0427e1a36)

