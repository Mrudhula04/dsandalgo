# KBitFlips Algorithm Flowchart

```mermaid
flowchart TD
    A[Start: Initialize n, res=0, flag=0, queue] --> B[Loop: i = 0 to n-1]
    
    B --> C{i >= k?}
    C -->|Yes| D[dequeue value from queue<br/>flag ^= dequeued_value]
    C -->|No| E{flag == 1?}
    D --> E
    
    E -->|Yes| F[Flip current bit<br/>arr[i] ^= 1]
    E -->|No| G{arr[i] == 0?}
    F --> G
    
    G -->|Yes| H{i + k > n?}
    G -->|No| I[enqueue(0)]
    
    H -->|Yes| J[Return -1<br/>Not enough elements]
    H -->|No| K[res++<br/>flag ^= 1<br/>enqueue(1)]
    
    K --> L[Continue loop]
    I --> L
    L --> M{i < n-1?}
    M -->|Yes| B
    M -->|No| N[Return res]
    
    J --> O[End]
    N --> O
    
    style A fill:#e1f5fe
    style J fill:#ffebee
    style N fill:#e8f5e8
    style O fill:#f3e5f5
```

## Key Points:

1. **Sliding Window**: Queue maintains flip history for window of size k
2. **Flag Tracking**: XOR operations track cumulative flip effect
3. **Dequeue Logic**: Remove old flip effects when i >= k
4. **Flip Decision**: If arr[i] == 0 after applying current flips, we must flip
5. **Boundary Check**: Ensure k elements remain for flipping
6. **Queue Updates**: Always enqueue current flip decision (1 or 0)

## Variables:
- `res`: Count of flip operations
- `flag`: Current cumulative flip state
- `queue`: Stores flip history for sliding window
- `i`: Current position in array
- `k`: Size of flip window