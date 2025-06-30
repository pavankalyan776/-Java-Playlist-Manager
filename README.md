# 🎵 Java Playlist Manager - LinkedList Implementation

> **A sophisticated music playlist management system demonstrating advanced data structure implementation and object-oriented programming principles.**

---

## 🚀 Project Overview

This project showcases a **dynamic playlist management system** built with Java, implementing both **Singly** and **Doubly Linked Lists** to efficiently handle music playlist operations. The system provides seamless navigation, real-time playlist modification, and optimized memory usage compared to traditional array-based solutions.

### 🎯 **Key Problem Solved**
Traditional arrays require expensive shifting operations when adding/removing elements. This implementation uses linked lists to achieve **O(1) insertion/deletion** at known positions and **O(n) traversal**, making it ideal for dynamic playlist management where frequent modifications are common.

---

## ✨ Features

### 🔧 **Core Functionality**
- ✅ **Dynamic Song Management** - Add/Remove songs efficiently
- ✅ **Duplicate Prevention** - Intelligent duplicate detection system  
- ✅ **Bidirectional Navigation** - Forward/Backward playlist traversal
- ✅ **Real-time Playback Control** - Next/Previous song functionality
- ✅ **Interactive Console Interface** - User-friendly menu system
- ✅ **Memory Efficient** - Optimized linked list implementation

### 🏗️ **Technical Highlights**
- **Two Implementation Variants**: Singly & Doubly Linked Lists
- **Object-Oriented Design**: Clean separation of concerns
- **Exception Handling**: Robust error management
- **Memory Management**: Efficient node creation/deletion
- **Code Reusability**: Modular component architecture

---

## 🛠️ Technology Stack

| Technology | Purpose | Version |
|------------|---------|---------|
| **Java** | Core Programming Language | JDK 8+ |
| **OOP Principles** | Design Methodology | - |
| **Data Structures** | LinkedList Implementation | Custom |
| **Console I/O** | User Interface | Built-in |

---

## 📁 Project Structure

```
src/
├── com/lesson/lab/
│   ├── Main.java                           # Application entry point
│   ├── controller/
│   │   ├── SinglyLinkedPlaylistManager.java    # Singly linked implementation
│   │   └── DoublyLinkedPlaylistManager.java    # Doubly linked implementation
│   └── model/
│       └── Song.java                       # Song entity model
```

---

## 💻 Code Showcase

### 🔗 **Efficient Song Addition (Doubly Linked List)**
```java
public void addFavoriteSong(Song newSong) {
    // Prevent duplicates with O(n) search
    if (isDuplicate(newSong)) {
        System.out.println("Song already exists in the playlist.");
        return;
    }
    
    Node newNode = new Node(newSong);
    if (head == null) {
        head = newNode;
        current = head;
    } else {
        // O(n) traversal to find tail, then O(1) insertion
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        newNode.previous = last;  // Bidirectional linking
    }
    System.out.println(newSong.getTitle() + " added to the playlist.");
}
```

### 🎯 **Smart Navigation System**
```java
public void playNextFavoriteSong() {
    if (current == null || current.next == null) {
        System.out.println("No next song in the playlist.");
    } else {
        current = current.next;  // O(1) navigation
        System.out.println("Now playing: " + current.song);
    }
}

public void playPreviousFavoriteSong() {
    if (current == null || current.previous == null) {
        System.out.println("No previous song in the playlist.");
    } else {
        current = current.previous;  // O(1) backward navigation
        System.out.println("Now playing: " + current.song);
    }
}
```

### 🏗️ **Robust Song Entity Model**
```java
public class Song {
    private String title;
    private String artist;
    private int duration;  // Duration in seconds
    private String genre;
    
    // Constructor with validation potential
    public Song(String title, String artist, int duration, String genre) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.genre = genre;
    }
    
    @Override
    public String toString() {
        return String.format("Song{title='%s', artist='%s', duration=%d, genre='%s'}", 
                           title, artist, duration, genre);
    }
}
```

---

## 🚀 Getting Started

### **Prerequisites**
- Java JDK 8 or higher
- IDE (IntelliJ IDEA, Eclipse, VS Code)
- Terminal/Command Prompt

### **Installation & Running**

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/Dynamic-Playlist-Manager-LinkedList.git
   cd Dynamic-Playlist-Manager-LinkedList
   ```

2. **Compile the project**
   ```bash
   javac -d bin src/com/lesson/lab/*.java src/com/lesson/lab/*/*.java
   ```

3. **Run the application**
   ```bash
   java -cp bin com.lesson.lab.Main
   ```

4. **Switch between implementations**
   - Edit `Main.java` to toggle between Singly/Doubly linked implementations
   - Uncomment desired manager type in the main method

---

## 🎮 Usage Demo

```
Favorite Song List Manager
1. Add a new song to favorites
2. Remove a song from favorites  
3. Display favorite songs list
4. Play next favorite song
5. Play previous favorite song
6. Start playing from the first favorite song
7. Exit

Available Songs:
1. Song{title='Song 1', artist='Artist A', duration=210, genre='Pop'}
2. Song{title='Song 2', artist='Artist B', duration=180, genre='Rock'}
3. Song{title='Song 3', artist='Artist C', duration=240, genre='Jazz'}
4. Song{title='Song 4', artist='Artist D', duration=200, genre='Classical'}
```

---

## 📊 Performance Analysis

| Operation | Singly Linked | Doubly Linked | Array |
|-----------|---------------|---------------|-------|
| **Add Song** | O(n) | O(n) | O(n) |
| **Remove Song** | O(n) | O(n) | O(n) |
| **Next Song** | O(1) | O(1) | O(1) |
| **Previous Song** | O(n) | O(1) | O(1) |
| **Memory Usage** | Lower | Higher | Fixed |

**Key Advantage**: No memory shifting required for insertions/deletions unlike arrays.

---

## 🔧 Technical Decisions

### **Why Linked Lists?**
- **Dynamic Size**: No pre-allocation needed
- **Efficient Insertion/Deletion**: No element shifting required
- **Memory Efficiency**: Allocate only what's needed
- **Real-world Application**: Models actual playlist behavior

### **Singly vs Doubly Linked**
- **Singly**: Memory efficient, forward navigation only
- **Doubly**: Bidirectional navigation, slightly higher memory usage
- **Use Case**: Doubly linked better for music applications requiring previous/next functionality

---

## 🌟 Learning Outcomes

This project demonstrates proficiency in:

- ✅ **Data Structures & Algorithms** - LinkedList implementation and analysis
- ✅ **Object-Oriented Programming** - Encapsulation, abstraction, modularity
- ✅ **Problem Solving** - Choosing optimal data structure for use case
- ✅ **Code Organization** - Clean architecture and separation of concerns
- ✅ **User Experience** - Intuitive console interface design
- ✅ **Performance Optimization** - Understanding time/space complexity trade-offs

---

## 🔮 Future Enhancements

- [ ] **Shuffle Functionality** - Random song selection algorithm
- [ ] **Playlist Persistence** - File I/O for saving/loading playlists
- [ ] **Search & Filter** - Song search by title, artist, or genre
- [ ] **GUI Implementation** - JavaFX or Swing interface
- [ ] **Streaming Integration** - API connections to music services
- [ ] **Advanced Navigation** - Jump to specific positions, bookmarks

---

## 🤝 Connect With Me

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/pavan-kalyan-406251231/)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/pavankalyan776)
[![Email](https://img.shields.io/badge/Email-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:kadavakollupavankalyan@gmail.com)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

<div align="center">

**⭐ If you found this project helpful, please give it a star! ⭐**

*Crafted with ❤️ for learning and demonstration purposes*

</div>
