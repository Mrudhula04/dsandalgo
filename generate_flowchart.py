import matplotlib.pyplot as plt
import matplotlib.patches as patches
from matplotlib.patches import FancyBboxPatch

fig, ax = plt.subplots(1, 1, figsize=(12, 16))

# Define positions and create boxes
boxes = [
    (6, 15, "START\nInitialize n, res=0\nflag=0, queue", 'lightblue'),
    (6, 13.5, "Loop: i = 0 to n-1", 'lightgray'),
    (6, 12, "i >= k?", 'yellow'),
    (3, 10.5, "dequeue value\nflag ^= value", 'orange'),
    (6, 9, "flag == 1?", 'yellow'),
    (3, 7.5, "arr[i] ^= 1", 'orange'),
    (6, 6, "arr[i] == 0?", 'yellow'),
    (9, 4.5, "enqueue(0)", 'lightgreen'),
    (3, 4.5, "i + k > n?", 'yellow'),
    (1, 3, "Return -1", 'red'),
    (5, 3, "res++\nflag ^= 1\nenqueue(1)", 'lightgreen'),
    (6, 1.5, "Return res", 'lightgreen')
]

# Draw boxes
for x, y, text, color in boxes:
    if '?' in text:  # Decision boxes (diamonds)
        box = FancyBboxPatch((x-0.8, y-0.4), 1.6, 0.8, 
                           boxstyle="round,pad=0.1", 
                           facecolor=color, edgecolor='black')
    else:  # Process boxes (rectangles)
        box = FancyBboxPatch((x-1, y-0.4), 2, 0.8, 
                           boxstyle="round,pad=0.1", 
                           facecolor=color, edgecolor='black')
    ax.add_patch(box)
    ax.text(x, y, text, ha='center', va='center', fontsize=8, weight='bold')

# Draw arrows
arrows = [
    (6, 14.6, 6, 14.1),    # START to Loop
    (6, 13.1, 6, 12.4),    # Loop to i>=k
    (5.2, 12, 3.8, 10.9),  # i>=k YES to dequeue
    (6, 11.6, 6, 9.4),     # i>=k NO to flag==1
    (3, 10.1, 3, 7.9),     # dequeue to arr[i]^=1
    (4.2, 9, 5.2, 9),      # flag==1 YES to arr[i]^=1
    (6, 8.6, 6, 6.4),      # flag==1 NO to arr[i]==0
    (3, 7.1, 4.5, 6.2),    # arr[i]^=1 to arr[i]==0
    (6.8, 6, 8.2, 4.9),    # arr[i]==0 NO to enqueue(0)
    (5.2, 6, 3.8, 4.9),    # arr[i]==0 YES to i+k>n
    (2.2, 4.5, 1.8, 3.4),  # i+k>n YES to Return -1
    (3.8, 4.5, 4.2, 3.4),  # i+k>n NO to res++
    (5, 2.6, 6, 1.9),      # res++ to Return res
    (9, 4.1, 7, 2.5),      # enqueue(0) to Return res (loop back)
]

for x1, y1, x2, y2 in arrows:
    ax.annotate('', xy=(x2, y2), xytext=(x1, y1),
                arrowprops=dict(arrowstyle='->', lw=1.5, color='black'))

# Add labels for decision branches
ax.text(4.5, 11.2, 'YES', fontsize=8, color='red', weight='bold')
ax.text(6.5, 11.2, 'NO', fontsize=8, color='green', weight='bold')
ax.text(4.5, 8.2, 'YES', fontsize=8, color='red', weight='bold')
ax.text(6.5, 8.2, 'NO', fontsize=8, color='green', weight='bold')
ax.text(7.5, 5.2, 'NO', fontsize=8, color='green', weight='bold')
ax.text(4.5, 5.2, 'YES', fontsize=8, color='red', weight='bold')
ax.text(2.5, 3.8, 'YES', fontsize=8, color='red', weight='bold')
ax.text(3.5, 3.8, 'NO', fontsize=8, color='green', weight='bold')

ax.set_xlim(-1, 11)
ax.set_ylim(0, 16)
ax.set_aspect('equal')
ax.axis('off')
ax.set_title('KBitFlips Algorithm Flowchart', fontsize=16, weight='bold', pad=20)

plt.tight_layout()
plt.savefig('/Users/mrudu/IdeaProjects/DataStructuresAndAlgorithms/kbitflips_flowchart.png', 
            dpi=300, bbox_inches='tight')
plt.show()