Отображение таблиц (tableViewer)
Необходимо сделать программу для отображения произвольной табличной структуры в консоли. Должен быть реализован класс ConsoleTableViewer<T>, при вызове метода show() которого происходит отрисовка таблицы в консоли. Кроме того в этом классе есть  методы setModelProvider(ModelProvider<T>) и setLabelProvier(LabelProvider<T>)
ModelProvider - имеет методы T[] getElements() для получения моделей-строк, метод Comparator<T> getComparator() для сортировки строк по нужному принципу
LabelProvider - int getColumnCount(), String getHeader(int), String getLabel(T, int)
