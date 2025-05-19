import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExtendedCalculator extends JFrame {

      private JTextField tf;

      // Переменные для вычислений
      private double a = 0, b = 0, result = 0;
      private int operator = 0; // 1:+, 2:-, 3:*, 4:/, 5:x^y
      private boolean nextInput = false; // для очистки поля при вводе после операции

      // Для повторного нажатия "="
      private double lastB = 0;
      private int lastOperator = 0;

      public ExtendedCalculator() {
            setTitle("Расширенный калькулятор");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(450, 600);
            setLocationRelativeTo(null);

            // Общий дисплей
            tf = new JTextField();
            tf.setFont(new Font("Arial", Font.BOLD, 30));
            tf.setHorizontalAlignment(JTextField.RIGHT);
            tf.setEditable(false);
            tf.setPreferredSize(new Dimension(400, 50));

            // Вкладки
            JTabbedPane tabbedPane = new JTabbedPane();

            // Базовый калькулятор
            JPanel basicPanel = createBasicPanel();

            // Расширенный калькулятор
            JPanel advancedPanel = createAdvancedPanel();

            tabbedPane.addTab("Базовый", basicPanel);
            tabbedPane.addTab("Расширенный", advancedPanel);

            // Компоновка окна
            setLayout(new BorderLayout(10, 10));
            add(tf, BorderLayout.NORTH);
            add(tabbedPane, BorderLayout.CENTER);

            setVisible(true);
      }

      private JPanel createBasicPanel() {
            JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));
            String[] buttons = {
                    "7", "8", "9", "/",
                    "4", "5", "6", "*",
                    "1", "2", "3", "-",
                    "0", ".", "=", "+"
            };
            for (String text : buttons) {
                  JButton btn = new JButton(text);
                  btn.setFont(new Font("Arial", Font.BOLD, 24));
                  btn.addActionListener(this::basicAction);
                  panel.add(btn);
            }

            // Кнопка очистки
            JButton clearBtn = new JButton("Очистить");
            clearBtn.setFont(new Font("Arial", Font.BOLD, 20));
            clearBtn.addActionListener(e -> clearAll());
            JPanel bottom = new JPanel(new BorderLayout());
            bottom.add(clearBtn, BorderLayout.CENTER);

            JPanel container = new JPanel(new BorderLayout(5, 5));
            container.add(panel, BorderLayout.CENTER);
            container.add(bottom, BorderLayout.SOUTH);
            return container;
      }

      private JPanel createAdvancedPanel() {
            JPanel panel = new JPanel(new GridLayout(5, 3, 5, 5));
            String[] advButtons = {
                    "sqrt", "x^2", "x^y",
                    "!", "1/x", "abs",
                    "sin", "cos", "tan",
                    "log", "ln", "e^x",
                    "Очистить", "=", "Отмена"
            };
            for (String text : advButtons) {
                  JButton btn = new JButton(text);
                  btn.setFont(new Font("Arial", Font.BOLD, 20));
                  btn.addActionListener(this::advancedAction);
                  panel.add(btn);
            }
            return panel;
      }

      // Обработка кнопок базового калькулятора
      private void basicAction(ActionEvent e) {
            String cmd = e.getActionCommand();

            if ("0123456789.".contains(cmd)) {
                  if (nextInput) {
                        tf.setText(cmd);
                        nextInput = false;
                  } else {
                        // Блокируем ввод нескольких точек
                        if (cmd.equals(".") && tf.getText().contains(".")) return;
                        tf.setText(tf.getText() + cmd);
                  }
            } else if ("+-*/".contains(cmd)) {
                  try {
                        a = Double.parseDouble(tf.getText());
                  } catch (NumberFormatException ex) {
                        tf.setText("Ошибка");
                        return;
                  }
                  operator = switch (cmd) {
                        case "+" -> 1;
                        case "-" -> 2;
                        case "*" -> 3;
                        case "/" -> 4;
                        default -> 0;
                  };
                  nextInput = true;
            } else if ("=".equals(cmd)) {
                  try {
                        if (operator == 0) {
                              // Повторное нажатие "=" - используем lastOperator и lastB
                              b = lastB;
                        } else {
                              b = Double.parseDouble(tf.getText());
                              lastB = b;
                              lastOperator = operator;
                        }
                  } catch (NumberFormatException ex) {
                        tf.setText("Ошибка");
                        return;
                  }

                  int op = (operator != 0) ? operator : lastOperator;

                  switch (op) {
                        case 1 -> result = a + b;
                        case 2 -> result = a - b;
                        case 3 -> result = a * b;
                        case 4 -> {
                              if (b == 0) {
                                    tf.setText("Деление на 0");
                                    return;
                              }
                              result = a / b;
                        }
                        default -> {
                              tf.setText("Ошибка");
                              return;
                        }
                  }

                  tf.setText(String.valueOf(result));
                  a = result;       // сохраняем результат как первый операнд для следующего вычисления
                  operator = 0;     // сбрасываем оператор
                  nextInput = true; // следующий ввод - новое число
            }
      }

      // Обработка кнопок расширенного калькулятора
      private void advancedAction(ActionEvent e) {
            String cmd = e.getActionCommand();
            double val;

            try {
                  val = Double.parseDouble(tf.getText());
            } catch (NumberFormatException ex) {
                  tf.setText("Ошибка");
                  return;
            }

            switch (cmd) {
                  case "sqrt" -> {
                        if (val < 0) {
                              tf.setText("Ошибка");
                              return;
                        }
                        tf.setText(String.valueOf(Math.sqrt(val)));
                        nextInput = true;
                  }
                  case "x^2" -> {
                        tf.setText(String.valueOf(val * val));
                        nextInput = true;
                  }
                  case "x^y" -> {
                        a = val;
                        operator = 5; // специальный оператор для степени
                        nextInput = true;
                  }
                  case "!" -> {
                        if (val < 0 || val != (int) val) {
                              tf.setText("Ошибка");
                              return;
                        }
                        tf.setText(String.valueOf(factorial((int) val)));
                        nextInput = true;
                  }
                  case "1/x" -> {
                        if (val == 0) {
                              tf.setText("Деление на 0");
                              return;
                        }
                        tf.setText(String.valueOf(1 / val));
                        nextInput = true;
                  }
                  case "abs" -> {
                        tf.setText(String.valueOf(Math.abs(val)));
                        nextInput = true;
                  }
                  case "sin" -> {
                        tf.setText(String.valueOf(Math.sin(Math.toRadians(val))));
                        nextInput = true;
                  }
                  case "cos" -> {
                        tf.setText(String.valueOf(Math.cos(Math.toRadians(val))));
                        nextInput = true;
                  }
                  case "tan" -> {
                        tf.setText(String.valueOf(Math.tan(Math.toRadians(val))));
                        nextInput = true;
                  }
                  case "log" -> {
                        if (val <= 0) {
                              tf.setText("Ошибка");
                              return;
                        }
                        tf.setText(String.valueOf(Math.log10(val)));
                        nextInput = true;
                  }
                  case "ln" -> {
                        if (val <= 0) {
                              tf.setText("Ошибка");
                              return;
                        }
                        tf.setText(String.valueOf(Math.log(val)));
                        nextInput = true;
                  }
                  case "e^x" -> {
                        tf.setText(String.valueOf(Math.exp(val)));
                        nextInput = true;
                  }
                  case "Очистить" -> clearAll();
                  case "=" -> {
                        if (operator == 5) { // степень x^y
                              try {
                                    if (nextInput) {
                                          b = lastB; // повторное нажатие "="
                                    } else {
                                          b = Double.parseDouble(tf.getText());
                                          lastB = b;
                                    }
                              } catch (NumberFormatException ex) {
                                    tf.setText("Ошибка");
                                    return;
                              }
                              result = Math.pow(a, b);
                              tf.setText(String.valueOf(result));
                              a = result;
                              operator = 0;
                              nextInput = true;
                        }
                  }
                  case "Отмена" -> {
                        String text = tf.getText();
                        if (!text.isEmpty()) {
                              tf.setText(text.substring(0, text.length() - 1));
                              nextInput = false; // сбрасываем флаг, чтобы можно было продолжить ввод
                        }
                  }
            }
      }

      private void clearAll() {
            tf.setText("");
            a = b = result = 0;
            operator = 0;
            lastB = 0;
            lastOperator = 0;
            nextInput = false;
      }

      private long factorial(int n) {
            if (n <= 1) return 1;
            return n * factorial(n - 1);
      }

      public static void main(String[] args) {
            SwingUtilities.invokeLater(ExtendedCalculator::new);
      }
}