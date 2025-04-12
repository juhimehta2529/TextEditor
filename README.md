# Text Editor in Java

![Java](https://img.shields.io/badge/Java-17%2B-blue)
![Swing](https://img.shields.io/badge/GUI-Swing-orange)

A simple yet functional text editor application built using Java Swing with undo/redo functionality, text formatting, and basic editing features.

## Features

- ✏️ **Text Insertion**: Add text with line-by-line input
- ♻️ **Undo/Redo**: Stack-based undo/redo operations
- 🎨 **Text Formatting**:
  - Bold text toggle
  - Adjustable font size (12, 14, 18)
- 🧹 **Clear All**: Reset the editor completely
- 🖥️ **User-Friendly Interface**: Color-coded buttons and clean layout

## Implementation Details

### Undo/Redo Mechanism
- Utilizes dual-stack architecture for efficient state management
- `insertedTextStack`: Tracks all successful text insertions
- `undoneTextStack`: Temporarily stores undone actions for potential redo
- Complete history reset when clearing the editor

### GUI Components
| Component       | Purpose                          | Customization                |
|-----------------|----------------------------------|------------------------------|
| `JTextArea`     | Main text display area           | Scrollable, non-editable     |
| `JTextField`    | User input field                 | Light gray background        |
| `JButton`       | Action triggers                  | Color-coded by functionality |
| `JScrollPane`   | Enables text area scrolling      | Wraps the JTextArea          |

### Font Management
- **Dynamic Sizing**: 
  - Implemented via `JOptionPane` dropdown
  - Supports 12pt, 14pt (default), and 18pt sizes
- **Style Toggle**:
  - Preserves current size when applying bold
  - Uses `Font.BOLD` constant for style modification

## How to Run
1. Ensure you have Java JDK 17+ installed
