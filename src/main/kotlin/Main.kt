package me.sig86.survey

import java.awt.EventQueue
import java.awt.Color
import java.awt.event.ItemEvent
import java.awt.event.ItemListener
import java.awt.Dimension
import javax.swing.JFrame
import javax.swing.GroupLayout
import javax.swing.JComponent
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JTextField
import javax.swing.JComboBox
import javax.swing.SwingConstants
import javax.swing.BorderFactory
import javax.swing.JPanel


class SurveyGUI() : JFrame(), ItemListener {

    private lateinit var userPanel: JPanel
    private lateinit var adminLoginPanel: JPanel
    private lateinit var adminPanel: JPanel

    init {
        setSize(800, 560)
        userUI()
    }

    private lateinit var surveyBox: JComboBox<String>
    private lateinit var surveyNameLabel: JLabel

    private fun userUI() {

        setTitle("Survey App - No Survey Selected")

        userPanel = JPanel()


        val surveyList = arrayOf("temp", "temp2")
        surveyBox = JComboBox<String>(surveyList)
        surveyBox.font = surveyBox.font.deriveFont(20f)
        surveyBox.addItemListener(this)
        surveyBox.setPreferredSize(Dimension(160, 80))
        surveyBox.setMinimumSize(surveyBox.getPreferredSize())
        surveyBox.setMaximumSize(surveyBox.getPreferredSize())
        userPanel.add(surveyBox)

        surveyNameLabel = JLabel("No Survey Selected", SwingConstants.CENTER)
        surveyNameLabel.font = surveyNameLabel.font.deriveFont(20f)
        surveyNameLabel.setForeground(Color(0xFFFFFF))
        surveyNameLabel.setPreferredSize(Dimension(360, 80))
        surveyNameLabel.setMinimumSize(surveyNameLabel.getPreferredSize())
        surveyNameLabel.setMaximumSize(surveyNameLabel.getPreferredSize())
        userPanel.add(surveyNameLabel)

        val adminPanelButton = JButton("Admin Panel")
        adminPanelButton.addActionListener {
            adminUI()
        }
        adminPanelButton.setPreferredSize(Dimension(160, 80))
        adminPanelButton.setMinimumSize(adminPanelButton.getPreferredSize())
        adminPanelButton.setMaximumSize(adminPanelButton.getPreferredSize())
        userPanel.add(adminPanelButton)

        val questionNumLabel = JLabel("Question #1", SwingConstants.CENTER)
        questionNumLabel.font = questionNumLabel.font.deriveFont(20f)
        questionNumLabel.setBorder(BorderFactory.createLineBorder(Color(0xFFFFFF)))
        questionNumLabel.setForeground(Color(0xFFFFFF))
        questionNumLabel.setPreferredSize(Dimension(360, 80))
        questionNumLabel.setMinimumSize(questionNumLabel.getPreferredSize())
        questionNumLabel.setMaximumSize(questionNumLabel.getPreferredSize())
        userPanel.add(questionNumLabel)

        val questionContentLabel = JLabel(". . .", SwingConstants.CENTER)
        questionContentLabel.font = questionContentLabel.font.deriveFont(14f)
        questionContentLabel.setBorder(BorderFactory.createLineBorder(Color(0xFFFFFF)))
        questionContentLabel.setForeground(Color(0xFFFFFF))
        questionContentLabel.setPreferredSize(Dimension(600, 80))
        questionContentLabel.setMinimumSize(questionContentLabel.getPreferredSize())
        questionContentLabel.setMaximumSize(questionContentLabel.getPreferredSize())
        userPanel.add(questionContentLabel)

        val answerField = JTextField()
        answerField.setForeground(Color(0x000000))
        answerField.setBackground(Color(0xAAAAAA))
        answerField.setBorder(BorderFactory.createLineBorder(Color(0xFFFFFF)))
        answerField.setPreferredSize(Dimension(600, 80))
        answerField.setMinimumSize(answerField.getPreferredSize())
        answerField.setMaximumSize(answerField.getPreferredSize())
        userPanel.add(answerField)

        val sendButton = JButton("Send Answer")
        sendButton.addActionListener {
            //
        }
        sendButton.setPreferredSize(Dimension(80, 80))
        sendButton.setMinimumSize(adminPanelButton.getPreferredSize())
        sendButton.setMaximumSize(adminPanelButton.getPreferredSize())
        userPanel.add(answerField)

        val endButton = JButton("End Survey")
        endButton.addActionListener {
            //
        }
        endButton.setPreferredSize(Dimension(80, 80))
        endButton.setMinimumSize(adminPanelButton.getPreferredSize())
        endButton.setMaximumSize(adminPanelButton.getPreferredSize())
        userPanel.add(endButton)


        contentPane.background = Color(0x000000)
        userPanel.background = Color(0x000000)

        defaultCloseOperation = EXIT_ON_CLOSE
        userPanel.setSize(800, 560)
        setLocationRelativeTo(null)
        createLayout(userPanel, surveyBox, surveyNameLabel, adminPanelButton, questionNumLabel, questionContentLabel, answerField, sendButton, endButton)

    }

    private fun adminUI() {

        setTitle("Survey App - Admin Panel")

        adminPanel = JPanel()


        val surveyList = arrayOf("temp", "temp2")
        surveyBox = JComboBox<String>(surveyList)
        surveyBox.font = surveyBox.font.deriveFont(20f)
        surveyBox.addItemListener(this)
        surveyBox.setPreferredSize(Dimension(160, 80))
        surveyBox.setMinimumSize(surveyBox.getPreferredSize())
        surveyBox.setMaximumSize(surveyBox.getPreferredSize())
        userPanel.add(surveyBox)

        val questionContentLabel = JLabel(". . .", SwingConstants.CENTER)
        userPanel.add(questionContentLabel)

        val userPanelButton = JButton("User Panel")
        userPanelButton.addActionListener {
            userUI()
        }
        userPanelButton.setPreferredSize(Dimension(160, 80))
        userPanelButton.setMinimumSize(userPanelButton.getPreferredSize())
        userPanelButton.setMaximumSize(userPanelButton.getPreferredSize())
        adminPanel.add(userPanelButton)


        contentPane.background = Color(0x000000)
        adminPanel.background = Color(0x000000)

        defaultCloseOperation = EXIT_ON_CLOSE
        adminPanel.setSize(800, 560)
        setLocationRelativeTo(null)
        createLayout(adminPanel, surveyBox, questionContentLabel, userPanelButton)

    }

    override fun itemStateChanged(e: ItemEvent) {

        surveyBox.setPreferredSize(Dimension(160, 80))
        if (e.stateChange == ItemEvent.SELECTED) {
            surveyNameLabel.setText(e.item.toString())
        }

    }

    private fun createLayout(panel: JPanel, vararg arg: JComponent) {

        contentPane.removeAll()
        contentPane.revalidate()

        val gl = GroupLayout(panel)
        panel.layout = gl

        gl.autoCreateContainerGaps = true
        gl.autoCreateGaps = true

        if (panel == userPanel) {

            gl.setHorizontalGroup(
                gl.createSequentialGroup()
                    .addGroup(
                        gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(arg[0])
                    )
                    .addGroup(
                        gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addComponent(arg[1])
                            .addComponent(arg[3])
                            .addComponent(arg[4])
                            .addComponent(arg[5])
                            .addGroup(
                                gl.createSequentialGroup()
                                    .addComponent(arg[6])
                                    .addGap(280)
                                    .addComponent(arg[7])
                            )
                    )
                    .addGroup(
                        gl.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(arg[2])
                    )
            )

            gl.setVerticalGroup(
                gl.createSequentialGroup()
                    .addGroup(
                        gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(arg[0])
                            .addComponent(arg[1])
                            .addComponent(arg[2])
                    )
                    .addGap(40)
                    .addGroup(
                        gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(arg[3])
                    )
                    .addGap(20)
                    .addGroup(
                        gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(arg[4])
                    )
                    .addGap(20)
                    .addGroup(
                        gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(arg[5])
                    )
                    .addGap(20)
                    .addGroup(
                        gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(arg[6])
                            .addComponent(arg[7])
                    )
            )

        }

        else if (panel == adminPanel) {

            gl.setHorizontalGroup(
                gl.createSequentialGroup()
                    .addGroup(
                        gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(arg[0])
                    )
                    .addGroup(
                        gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addComponent(arg[1])
                    )
                    .addGroup(
                        gl.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(arg[2])
                    )
            )

            gl.setVerticalGroup(
                gl.createSequentialGroup()
                    .addGroup(
                        gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(arg[0])
                            .addComponent(arg[1])
                            .addComponent(arg[2])
                    )
            )

        }

        // using pack resizes the screen to fit perfectly
        add(panel)
        val a = getSize()
        pack()
        setMinimumSize(a)

    }

}


private fun createAndShowGUI() {

    val frame = SurveyGUI()
    frame.isVisible = true

}


fun main() {

    EventQueue.invokeLater(::createAndShowGUI)

}