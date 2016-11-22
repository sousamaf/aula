import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
//import com.mxgraph.examples.swing.FixedPoints;


import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
	
public class Interface extends JFrame
{
	private static final long serialVersionUID = -2707712944901661771L;

	@SuppressWarnings("unused")
	public Interface(ArrayList<String> arrayVertice, ArrayList<String[]> arrayAdj, ArrayList<String[]> arrayCusto)
	{

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(376, 85, 935, 600);
		setUndecorated(true);
		
//		super("Hello, World!");
		int radius = 230;
		int gapX = 240;
		int gapY = 70;
		int slices = arrayVertice.size();
		int side = 60;
		Object[] insert = new Object[arrayVertice.size()];
		
		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();
		try
		{
			graph.setCellsMovable(true);
			graph.setCellsSelectable(true);
			graph.setAllowDanglingEdges(false);
			graph.setCellsEditable(true);
			
			if(arrayVertice.size() > 11)
			{
				graph.insertVertex(parent, null, "Grafo muito grande para ser desenhado!", 350, 250, 250, 50, null);
			}
			else
			{
				Map<String, Object> edgeStyle = new HashMap<String, Object>();
				edgeStyle.put(mxConstants.STYLE_SHAPE,    mxConstants.SHAPE_CONNECTOR);
				edgeStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_CLASSIC);
				edgeStyle.put(mxConstants.STYLE_STROKECOLOR, "#000000");
				edgeStyle.put(mxConstants.STYLE_FONTCOLOR, "#000000");
				edgeStyle.put(mxConstants.STYLE_LABEL_BACKGROUNDCOLOR, "#ffffff");
				edgeStyle.put(mxConstants.STYLE_FONTSIZE, "12");

				mxStylesheet stylesheet = new mxStylesheet();
				stylesheet.setDefaultEdgeStyle(edgeStyle);
				graph.setStylesheet(stylesheet);
				
				for(int i = 0; i < slices; i++)
				{
					double phi = (i * Math.PI * 2) / slices; 
					int x = (int) (radius * Math.sin(phi) + radius - side / 2) + gapX;
					int y = (int) (radius * Math.cos(phi) + radius - side / 2) + gapY;
					insert[i] = graph.insertVertex(parent, null, arrayVertice.get(i), x, y, side, side, "shape=ellipse;perimeter=ellipsePerimeter;fillColor=yellow");
				}
				
				for(int i = 0; i < arrayAdj.size(); i++)
				{
					int cont = arrayAdj.size();
					for(int j = 0; j < arrayAdj.get(i).length; j++)
					{
						for(int z = 0; z < cont; z++)
						{
							if(arrayAdj.get(i)[j].equals("v" + z))
							{
								graph.insertEdge(parent, null, arrayCusto.get(i)[j], insert[i], insert[z]);
							}
						}
					}
				}
			}
		}
		finally
		{
			graph.getModel().endUpdate();
		}

		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		graphComponent.setConnectable(false);
		getContentPane().add(graphComponent);
		setVisible(true);
	}
}
