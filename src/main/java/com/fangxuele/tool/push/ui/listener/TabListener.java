package com.fangxuele.tool.push.ui.listener;

import com.fangxuele.tool.push.ui.form.MainWindow;
import com.fangxuele.tool.push.ui.form.MessageEditForm;
import com.fangxuele.tool.push.ui.form.PushForm;
import com.fangxuele.tool.push.ui.form.PushHisForm;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * <pre>
 * tab事件监听
 * </pre>
 *
 * @author <a href="https://github.com/rememberber">RememBerBer</a>
 * @since 2017/6/21.
 */
public class TabListener {

    private static boolean warnFlag = true;

    public static void addListeners() {
        MainWindow.mainWindow.getTabbedPane().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int index = MainWindow.mainWindow.getTabbedPane().getSelectedIndex();
                switch (index) {
                    case 6:
                        PushHisForm.init();
                        break;
                    case 3:
                        if (warnFlag) {
                            JOptionPane.showMessageDialog(MainWindow.mainWindow.getSettingPanel(), "\n请确认您了解所要发送消息类型的使用频率、使用规范和限制规则，\n" +
                                            "以免账号相关功能被封禁等给您带来麻烦", "提示",
                                    JOptionPane.INFORMATION_MESSAGE);
                            warnFlag = false;
                        }
                        break;
                    case 4:
                        PushForm.pushForm.getPushMsgName().setText(MessageEditForm.messageEditForm.getMsgNameField().getText());
                        PushListener.refreshPushInfo();
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
