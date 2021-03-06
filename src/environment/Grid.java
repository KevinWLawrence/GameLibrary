/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package environment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author kevinlawrence
 */
public class Grid implements Paintable {

    private int columns;
    private int rows;
    private int cellWidth;
    private int cellHeight;
    private Point position;
    private Color color;

    //   <editor-fold defaultstate="collapsed" desc="Constructors">
    public Grid() {
        this.columns = 20;
        this.rows = 10;
        this.cellWidth = 20;
        this.cellHeight = 20;
        this.position = new Point(10, 10);
        this.color = Color.GRAY;
    }

    public Grid(int columns, int rows, int cellWidth, int cellHeight, Point position, Color color) {
        this.columns = columns;
        this.rows = rows;
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
        this.position = position;
        this.color = color;
    }
//  </editor-fold>

    //   <editor-fold defaultstate="collapsed" desc="Paintable">
    @Override
    public void paintComponent(Graphics graphics) {
//        graphics.setColor(color);
//
//        for (int row = 0; row < rows; row++) {
//            for (int column = 0; column < columns; column++) {
//                graphics.drawRect(position.x + (column * cellWidth),
//                        position.y + (row * cellHeight),
//                        cellWidth, cellHeight);
//            }
//        }
        paint(graphics, position, columns, rows,  cellWidth, cellHeight, color);
    }

//  </editor-fold>
 
    //   <editor-fold defaultstate="collapsed" desc="Methods">

    /**  By Kevin Lawrence
     * @param graphics the Graphics surface upon which to draw
     * @param position the system coordinate location of the top left corner of the grid
     * @param columns the number of columns in the grid
     * @param rows the number of rows in the grid
     * @param cellWidth the width of each cell in the grid in pixels
     * @param cellHeight the height of each cell in the grid in pixels
     * @param color the color to draw the grid
     * 
     * Draws a grid based on input parameters.
     */
    public static void paint(Graphics graphics, Point position, int columns, int rows, int cellWidth, int cellHeight, Color color) {
        graphics.setColor(color);

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                graphics.drawRect(position.x + (column * cellWidth),
                        position.y + (row * cellHeight),
                        cellWidth, cellHeight);
            }
        }
    }
    
    /**
     * @return a Point(x, y) coordinate of the top left position of the cell
     * Note that this does not validate if the row and column input parameters
     * are valid (i.e. contained within the limits of the size of the grid).
     */
    public Point getCellPosition(int column, int row) {
        int x = position.x + (column * cellWidth);
        int y = position.y + (row * cellHeight);

        return new Point(x, y);
    }

    /**
     * @return a Point(x, y) coordinate of the top left position of the cell
     * Note that this does not validate if the row and column input parameters
     * are valid (i.e. contained within the limits of the size of the grid).
     */
    public Point getCellPosition(Point point) {
        return getCellPosition(point.x, point.y);
    }

    /**  By Kevin Lawrence
     * @param systemCoordinateX the x coordinate, based on the graphics system
     * @param systemCoordinateY the y coordinate, based on the graphics system
     * 
     * @return a Point(x, y) which is the decoded [x, y] coordinate of the top 
     * left position of the cell that contains the input system coordinates
     * Note that this does not validate if the row and column input parameters
     * are valid (i.e. contained within the limits of the size of the grid).
     */
    public Point getCellLocationFromSystemCoordinate(int systemCoordinateX, int systemCoordinateY) {
        int cellCoordinateX = (systemCoordinateX - getPosition().x) / getCellWidth();
        int cellCoordinateY = (systemCoordinateY - getPosition().y) / getCellHeight();

        return new Point(cellCoordinateX, cellCoordinateY);
    }
    
    /**  By Kevin Lawrence
     * @param systemCoordinate the point to be assess, based on the graphics system
     * 
     * @return a Point(x, y) which is the decoded [x, y] coordinate of the top 
     * left position of the cell that contains the input system coordinates
     * Note that this does not validate if the row and column input parameters
     * are valid (i.e. contained within the limits of the size of the grid).
     */
    public Point getCellLocationFromSystemCoordinate(Point systemCoordinate) {
        return getCellLocationFromSystemCoordinate(systemCoordinate.x, systemCoordinate.y);
    } 
//   </editor-fold>

    //   <editor-fold defaultstate="collapsed" desc="Properties">
    /**
     * @return Point having x = cell width and y = cell height
     */
    public Point getCellSize() {
        return new Point(cellWidth, cellHeight);
    }

    /**
     * @return the columns
     */
    public int getColumns() {
        return columns;
    }

    /**
     * @param columns the columns to set
     */
    public void setColumns(int columns) {
        this.columns = columns;
    }

    /**
     * @return the rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * @return the cellWidth
     */
    public int getCellWidth() {
        return cellWidth;
    }

    /**
     * @param cellWidth the cellWidth to set
     */
    public void setCellWidth(int cellWidth) {
        this.cellWidth = cellWidth;
    }

    /**
     * @return the cellHeight
     */
    public int getCellHeight() {
        return cellHeight;
    }

    /**
     * @param cellHeight the cellHeight to set
     */
    public void setCellHeight(int cellHeight) {
        this.cellHeight = cellHeight;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the position
     */
    public Point getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Point position) {
        this.position = position;
    }
//  </editor-fold>
    
}
