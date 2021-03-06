
package chatty.gui.components.settings;

import chatty.util.api.usericons.Usericon;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.util.List;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author tduva
 */
public class ImageSettings extends SettingsPanel {
    
    private final UsericonEditor usericonsData;
    
    public ImageSettings(SettingsDialog d) {
        super(true);
        
        GridBagConstraints gbc;
        
        JPanel usericons = addTitledPanel("Usericon Settings (Badges)", 0, true);

        gbc = d.makeGbcCloser(0, 0, 1, 1, GridBagConstraints.WEST);
        usericons.add(d.addSimpleBooleanSetting("usericonsEnabled","Show Usericons",
                "Show mod/turbo/.. as icons. Changing this only affects new lines."),
                gbc);
        
        gbc = d.makeGbcCloser(0, 1, 1, 1, GridBagConstraints.WEST);
        gbc.insets.left += 10;
        usericons.add(d.addSimpleBooleanSetting("customUsericonsEnabled", "Enable Custom Usericons (table below)",
                "Configure custom usericons in the table below."), gbc);
        
        gbc = d.makeGbcCloser(1, 0, 2, 1, GridBagConstraints.WEST);
        usericons.add(d.addSimpleBooleanSetting("botBadgeEnabled", "Enable Bot Badge", ""), gbc);
        
        gbc = d.makeGbcCloser(1, 1, 1, 1, GridBagConstraints.WEST);
        gbc.insets.left += 10;
        usericons.add(d.addSimpleBooleanSetting("botNamesBTTV", "BTTV",
                "Loads bot names from the BTTV API to give them the bot badge. BTTV emotes have to be enabled."), gbc);
        
        gbc = d.makeGbcCloser(2, 1, 1, 1, GridBagConstraints.WEST);
        gbc.insets.left += 10;
        usericons.add(d.addSimpleBooleanSetting("botNamesFFZ", "FFZ",
                "Loads bot names from the FFZ API to give them the bot badge. FFZ emotes have to be enabled."), gbc);
        
        usericonsData = new UsericonEditor(d, d.getLinkLabelListener());
        usericonsData.setPreferredSize(new Dimension(150, 250));
        gbc = d.makeGbc(0, 2, 3, 1);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        gbc.weightx = 1;
        usericons.add(usericonsData, gbc);
        
        gbc = d.makeGbc(0, 3, 3, 1, GridBagConstraints.WEST);
        usericons.add(new JLabel("Tip: Add a Usericon with no image to hide badges of that type"), gbc);
    }
    
    public void setData(List<Usericon> data) {
        usericonsData.setData(data);
    }
    
    public void setTwitchBadgeTypes(Set<String> data) {
        usericonsData.setTwitchBadgeTypes(data);
    }
    
    public List<Usericon> getData() {
        return usericonsData.getData();
    }
    
    public void addUsericonOfBadgeType(String idVersion) {
        usericonsData.addUsericonOfBadgeType(idVersion);
    }
    
}
