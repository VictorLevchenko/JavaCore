package rf_ID;

import javax.swing.DefaultComboBoxModel;

import com.fazecast.jSerialComm.SerialPort;

class PortComboBoxModel extends DefaultComboBoxModel<SerialPort> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PortComboBoxModel(SerialPort[] ports) {
        super(ports);
    }
 
    @Override
    public SerialPort getSelectedItem() {
        SerialPort selectedPort = (SerialPort) super.getSelectedItem();
 
        // do something with this job before returning...
 
        return selectedPort;
    }
}