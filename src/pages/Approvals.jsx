import { useState, useEffect } from 'react';
import { CheckSquare, Check, X, Search } from 'lucide-react';
import api from '../api/axios';

export default function Approvals() {
  const [approvals, setApprovals] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchApprovals();
  }, []);

  const fetchApprovals = async () => {
    try {
      setLoading(true);
      const response = await api.get('/approvals');
      setApprovals(response.data || []);
    } catch (error) {
      console.error("Error fetching approvals:", error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="page-container">
      <div className="page-header">
        <div>
          <h1 className="title-gradient" style={{ fontSize: '2rem' }}>Approvals Inbox</h1>
          <p style={{ color: 'var(--text-secondary)' }}>Review and process pending requests and purchase orders.</p>
        </div>
      </div>

      <div className="glass-panel vendors-content">
        <div className="table-controls">
          <div className="search-box">
            <Search size={18} className="search-icon" />
            <input 
              type="text" 
              placeholder="Search requests..." 
              className="input-base"
              style={{ paddingLeft: '2.5rem' }}
            />
          </div>
          <div className="filters">
            <select className="input-base" style={{ width: 'auto', padding: '0.5rem' }}>
              <option value="PENDING">Pending Actions</option>
              <option value="APPROVED">Already Approved</option>
              <option value="REJECTED">Rejected</option>
            </select>
          </div>
        </div>

        {loading ? (
          <div className="loading-state">Loading approvals...</div>
        ) : (
          <div className="table-container">
            <table className="table">
              <thead>
                <tr>
                  <th>Approval ID</th>
                  <th>Request Type</th>
                  <th>Submitted Date</th>
                  <th>Status</th>
                  <th style={{ textAlign: 'right' }}>Decision</th>
                </tr>
              </thead>
              <tbody>
                {approvals.length > 0 ? approvals.map((approval) => (
                  <tr key={approval.approvalId}>
                    <td style={{ fontWeight: 500 }}>APP-{approval.approvalId}</td>
                    <td>{approval.entityType || 'Purchase Order'}</td>
                    <td>{approval.approvalDate ? new Date(approval.approvalDate).toLocaleDateString() : 'Pending'}</td>
                    <td>
                      <span className={`badge ${approval.status === 'APPROVED' ? 'badge-success' : approval.status === 'REJECTED' ? 'badge-danger' : 'badge-warning'}`}>
                        {approval.status || 'PENDING'}
                      </span>
                    </td>
                    <td>
                      {approval.status === 'PENDING' ? (
                        <div className="action-buttons">
                          <button className="btn btn-secondary" style={{ padding: '0.25rem 0.5rem', color: 'var(--secondary)', borderColor: 'var(--secondary)' }}>
                            <Check size={16} /> Approve
                          </button>
                          <button className="btn btn-secondary" style={{ padding: '0.25rem 0.5rem', color: 'var(--danger)', borderColor: 'var(--danger)' }}>
                            <X size={16} /> Reject
                          </button>
                        </div>
                      ) : (
                        <div style={{ textAlign: 'right', color: 'var(--text-secondary)', fontSize: '0.875rem' }}>
                          Processed
                        </div>
                      )}
                    </td>
                  </tr>
                )) : (
                  <tr>
                    <td colSpan="5" style={{ textAlign: 'center', padding: '3rem', color: 'var(--text-secondary)' }}>
                      <CheckSquare size={48} style={{ opacity: 0.2, margin: '0 auto 1rem' }} />
                      <div>Your inbox is clear! No pending approvals.</div>
                    </td>
                  </tr>
                )}
              </tbody>
            </table>
          </div>
        )}
      </div>
    </div>
  );
}
