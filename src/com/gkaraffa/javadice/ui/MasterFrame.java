package com.gkaraffa.javadice.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.gkaraffa.javadice.control.Application;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MasterFrame extends JFrame {

  private JPanel contentPane;
  private JTextField resultTextField;
  private JLabel lblSides;
  private JComboBox<String> cBSides;
  private JLabel lblRolls;
  private JComboBox<String> cBRolls;
  private JLabel lblResult;
  private JButton rollButton;
  private Application controller;
  private JLabel lblResultArea;
  private JTextArea resultTextArea;


  public MasterFrame(Application controller) {
    this.controller = controller;
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 283, 260);
    contentPane = createContentPane();
    setContentPane(contentPane);
    contentPane.setLayout(null);

    lblSides = createSidesLabel();
    contentPane.add(lblSides);

    lblRolls = createRollsLabel();
    contentPane.add(lblRolls);

    cBSides = this.createSidesCB();
    contentPane.add(cBSides);

    cBRolls = this.createRollsCB();
    contentPane.add(cBRolls);

    lblResult = this.createResultLabel();
    contentPane.add(lblResult);

    resultTextField = this.createResultTextField();
    contentPane.add(resultTextField);

    rollButton = this.createButton();
    contentPane.add(rollButton);

    lblResultArea = this.createResultAreaLabel();
    contentPane.add(lblResultArea);

    resultTextArea = this.createResultArea();
    contentPane.add(resultTextArea);
  }

  private JPanel createContentPane() {
    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    return contentPane;
  }

  private JTextArea createResultArea() {
    JTextArea textArea = new JTextArea();
    textArea.setBounds(60, 99, 208, 93);

    return textArea;
  }

  private JLabel createResultAreaLabel() {
    JLabel lblResultSet = new JLabel("Result Set");
    lblResultSet.setBounds(6, 70, 71, 16);

    return lblResultSet;
  }

  private JLabel createSidesLabel() {
    JLabel lblSides = new JLabel("Sides:");
    lblSides.setBounds(143, 6, 42, 16);

    return lblSides;
  }

  private JLabel createRollsLabel() {
    JLabel lblRolls = new JLabel("Rolls:");
    lblRolls.setBounds(6, 6, 42, 16);

    return lblRolls;
  }

  private JComboBox<String> createSidesCB() {
    JComboBox<String> cBSides = new JComboBox<String>();
    cBSides.addItem("4");
    cBSides.addItem("6");
    cBSides.addItem("8");
    cBSides.addItem("10");
    cBSides.addItem("12");
    cBSides.addItem("20");
    cBSides.setBounds(197, 2, 71, 27);

    return cBSides;
  }

  private JComboBox<String> createRollsCB() {
    JComboBox<String> cBRolls = new JComboBox<String>();
    for (int index = 1; index <= 10; index++) {
      cBRolls.addItem(Integer.toString(index));
    }
    cBRolls.setBounds(60, 2, 71, 27);

    return cBRolls;
  }

  private JLabel createResultLabel() {
    JLabel lblResult = new JLabel("Result:");
    lblResult.setBounds(6, 34, 50, 16);

    return lblResult;
  }

  private JTextField createResultTextField() {
    JTextField resultTextField = new JTextField();
    resultTextField.setBounds(60, 29, 71, 26);
    resultTextField.setColumns(10);

    return resultTextField;
  }

  private JButton createButton() {
    JButton rollButton = new JButton("Roll");
    rollButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String sideString = (String) cBSides.getSelectedItem();
        String rollString = (String) cBRolls.getSelectedItem();

        /*
        int resultInt = controller.executeRoll(sideString, rollString);
        String resultString = Integer.toString(resultInt);
        */

        controller.executeRoll(sideString, rollString);
        resultTextField.setText(String.valueOf(controller.getResAgg()));

        StringBuilder sBuild = new StringBuilder();
        int[] resAry = controller.getResAry();
        for (int curRes : resAry) {
          sBuild.append(curRes + ", ");
        }
        sBuild.delete(sBuild.length() - 2, sBuild.length());
        
        resultTextArea.setText(sBuild.toString());
      }
    });
    rollButton.setBounds(151, 204, 117, 29);

    return rollButton;
  }
}
