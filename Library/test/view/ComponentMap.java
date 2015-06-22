package view;

import java.awt.Component;
import java.awt.Container;
import java.util.HashMap;

import javax.swing.JFrame;

/**
 * A class that maintains a hashmap of all of the components in a Frame and
 * supports retrieving them by their names. Note that the hashmap is built on
 * creation of the object and will contain only the components that have been
 * added to the frame at that time - the hashmap is NOT updated if the contents
 * of the frame change.
 * 
 * @author Merlin
 *
 */
public class ComponentMap
{
	private HashMap<String, Component> componentMap;

	/**
	 * Create the map for a given frame
	 * @param frame the frame we are interested in
	 */
	ComponentMap(Container container)
	{
		componentMap = new HashMap<String, Component>();
		Component[] components = container.getComponents();
		addToMap(components);
	}

	private void addToMap(Component[] components)
	{
		for (int i = 0; i < components.length; i++)
		{
			componentMap.put(components[i].getName(), components[i]);
			if (components[i] instanceof Container)
			{
				Component[] children = ((Container) (components[i]))
						.getComponents();

				addToMap(children);

			}

		}
	}

	/**
	 * @param name the name of the component we are searching for
	 * @return the component or null of none with that name is found
	 */
	public Component getComponentByName(String name)
	{
		if (componentMap.containsKey(name))
		{
			return (Component) componentMap.get(name);
		} else
			return null;
	}
}
