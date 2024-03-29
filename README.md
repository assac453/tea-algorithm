## Описание программы

Реализован алгоритм **TEA** в режиме работы **ECB**

Link https://en.wikipedia.org/wiki/Tiny_Encryption_Algorithm

## Руководство пользователя

Программа взаимодействует с пользователем за счет редактирования файлов. Ниже приведено описание файлов, которые необходимо использовать (находятся в каталоге `src/main/resources`):

- **input.txt**: В этот файл вводится текст, который нужно зашифровать.
- **key.txt**: В этот файл необходимо записать 4 целых числа типа Integer, которые будут использоваться в качестве ключа для шифрования.
- **decrypted.txt**: В этот файл будет записан дешифрованный текст.
- **encrypted.txt**: В этот файл будет записан зашифрованный текст.

### Конфигурационный файл `application.yaml`

```yaml
file:
 path:
   input: "src/main/resources/input.txt"
   encrypt: "src/main/resources/encrypt.txt"
   decrypt: "src/main/resources/decrypt.txt"
   key: "src/main/resources/key.txt"

```

## Требования для запуска
* Java 17+
* Maven

## Ввод даных
На входе программе подаётся следующая информация:
* Ключ: 
  * 1000000007 
  * 1000000009 
  * 1000000019 
  * 1000000123
* Содержимое файла `input.txt`: Любой текст произвольной длины, который помещается в оперативную память.

## Результат работы программы
После выполнения программы содержимое файлов будет следующим:
* Зашифрованный текст (`encrypted.txt`): Находится в двоичном формате, поэтому его корректное отображение в текстовом виде невозможно.
* Дешифрованный текст (`decrypted.txt`): Содержит текст, аналогичный содержимому файла `input.txt`.
